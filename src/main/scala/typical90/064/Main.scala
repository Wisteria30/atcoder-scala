import java.util.Scanner
import scala.collection.mutable

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val N, Q = sc.nextInt
  val A = IndexedSeq.fill(N)(sc.nextInt)
  val diff = mutable.IndexedSeq.fill(N + 5)(0L)
  var ans: Long = 0
  for (i <- 1 until N) {
    diff(i) = A(i) - A(i - 1)
    ans += math.abs(diff(i))
  }

  for (i <- 0 until Q) {
    val L, R, V = sc.nextInt
    val before: Long = math.abs(diff(L - 1)) + math.abs(diff(R))
    if (L >= 2) diff(L - 1) += V
    if (R < N) diff(R) -= V
    val after: Long = math.abs(diff(L - 1)) + math.abs(diff(R))
    ans += (after - before)
    println(ans)
  }
}