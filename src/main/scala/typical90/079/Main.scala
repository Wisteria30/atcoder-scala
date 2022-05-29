import java.util.Scanner
import scala.collection.mutable

object Main extends App {
  private implicit def intIsZero(i: Int): Boolean = if (i == 0) true else false

  val sc: Scanner = new Scanner(System.in)

  val H, W = sc.nextInt
  val A = IndexedSeq.fill(H)(IndexedSeq.fill(W)(sc.nextInt))
  val B = IndexedSeq.fill(H)(IndexedSeq.fill(W)(sc.nextInt))
  //  X + (A - B) = 0 => X = B - A
  val BminusA = mutable.IndexedSeq.fill(H)(mutable.IndexedSeq.fill(W)(0))

  for (i <- 0 until H) {
    for (j <- 0 until W) {
      BminusA(i)(j) = B(i)(j) - A(i)(j)
    }
  }
  val nx = List(0, 1, 0, 1)
  val ny = List(0, 0, 1, 1)
  //  @formatter:off
  var cnt = 0L

  for (i <- 0 until H - 1) {
    for (j <- 0 until W - 1) {
      val diff = -BminusA(i)(j)
      for (k <- 0 until 4) {
        val dx = j + nx(k)
        val dy = i + ny(k)
        BminusA(dy)(dx) += diff
      }
      cnt += math.abs(diff)
    }
  }

  //  @formatter:off
  var ans = BminusA.foldLeft(true)((acc, i) => i.foldLeft(true)((acc2, j) => acc2 & j) & acc)

  if (ans) {
    println("Yes")
    println(cnt)
  } else {
    println("No")
  }
}
