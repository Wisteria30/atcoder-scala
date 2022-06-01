import java.util.Scanner
import scala.annotation.tailrec
import scala.collection.mutable

class UnionFind(sz: Int) {
  private val data = mutable.IndexedSeq.fill(sz)(-1)

  def unite(x: Int, y: Int): Boolean = {
    val xRoot = find(x)
    val yRoot = find(y)
    if (xRoot == yRoot) return false
    if (data(xRoot) < data(yRoot)) {
      data(xRoot) += data(yRoot)
      data(yRoot) = xRoot
    } else {
      data(yRoot) += data(xRoot)
      data(xRoot) = yRoot
    }
    true
  }

  @tailrec
  final def find(k: Int): Int = {
    if (data(k) < 0) k
    else find(data(k))
  }

  def size(k: Int): Int = {
    -data(find(k))
  }

  def same(x: Int, y: Int): Boolean = {
    find(x) == find(y)
  }

  def groups(): mutable.IndexedSeq[mutable.IndexedSeq[Int]] = {
    val ret = mutable.IndexedSeq.fill(data.size)(mutable.IndexedSeq.empty[Int])
    for (i <- data.indices) {
      ret(find(i)) :+= i
    }
    ret.filter(_.nonEmpty)
  }
}


object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val H, W = sc.nextInt
  val field = mutable.IndexedSeq.fill(H, W)(false)
  val uf = new UnionFind(H * W)
  val Q = sc.nextInt
  for (_ <- 0 until Q) {
    val q = sc.nextInt
    q match {
      case 1 =>
        val r, c = sc.nextInt - 1
        field(r)(c) = true
        val dr = Array(1, 0, -1, 0)
        val dc = Array(0, 1, 0, -1)
        for (i <- 0 until 4) {
          val nr = r + dr(i)
          val nc = c + dc(i)
          if (0 <= nr && nr < H && 0 <= nc && nc < W && field(nr)(nc)) {
            uf.unite(point2num(r, c), point2num(nr, nc))
          }
        }
      case 2 =>
        val ra, ca, rb, cb = sc.nextInt - 1
        if ((field(ra)(ca) && field(rb)(cb)) && uf.same(point2num(ra, ca), point2num(rb, cb))) {
          println("Yes")
        } else {
          println("No")
        }
    }
  }

  def point2num(h: Int, w: Int): Int = {
    h * W + w
  }
}