import java.util.Scanner
import scala.collection.mutable

object Main extends App {
  val sc: Scanner = new Scanner(System.in)
  val INF = 1000000007

  val N = sc.nextInt
  val S = IndexedSeq.fill(N)(sc.next)
  var ans = INF
  for (i <- 0 until 10) {
    val hash = mutable.IndexedSeq.fill(10)(0)
    for (s <- S) {
      hash(s.indexOf(i.toString)) += 1
    }
    val maxHash = hash.zipWithIndex.sortWith((a, b) => a._2 > b._2).sortWith((a, b) => a._1 > b._1)(0)
    ans = ans.min(10 * (maxHash._1 - 1) + maxHash._2)
  }
  println(ans)
}
