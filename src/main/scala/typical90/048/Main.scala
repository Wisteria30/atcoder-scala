import java.util.Scanner
import scala.collection.mutable

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val N, K = sc.nextInt
  val A = mutable.IndexedSeq.fill(N)(0)
  val B = mutable.IndexedSeq.fill(N)(0)
  for (i <- 0 until N) {
    A(i) = sc.nextInt
    B(i) = sc.nextInt
  }

  //  score, index, AorB
  var scores = mutable.ArrayBuffer[Int]()
  for (i <- 0 until N) {
    scores += A(i) - B(i)
    scores += B(i)
  }
  scores = scores.sortWith(_ > _)
  var ans = 0L
  for (i <- 0 until K) {
    ans += scores(i)
  }
  println(ans)
}