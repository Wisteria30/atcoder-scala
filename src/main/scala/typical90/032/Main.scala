import java.util.Scanner
import scala.collection.mutable

object Main extends App {
  val sc: Scanner = new Scanner(System.in)
  val INF = 10000000

  val n = sc.nextInt
  val a = IndexedSeq.fill(n, n)(sc.nextInt)
  val m = sc.nextInt
  var unlikeSet = Set[(Int, Int)]()
  for (_ <- 0 until m) {
    val x = sc.nextInt - 1
    val y = sc.nextInt - 1
    unlikeSet = unlikeSet + ((x, y))
    unlikeSet = unlikeSet + ((y, x))
  }
  var ans = fullSearch(-1, 0, (0 until n).toSet)
  if (ans >= INF) {
    println(-1)
  } else {
    println(ans)
  }

  def fullSearch(prev: Int, cost: Int, remaining: Set[Int]): Int = {
    if (remaining.isEmpty) return cost
    val cost_ = mutable.IndexedSeq.fill(n)(cost)
    for (cur <- remaining) {
      if (unlikeSet.contains((prev, cur))) {
        cost_(cur) += INF
      } else {
        cost_(cur) += fullSearch(cur, a(cur)(n - remaining.size), remaining - cur)
      }
    }
    cost_.zipWithIndex.filter(t => remaining.contains(t._2)).minBy(_._1)._1
  }
}
