import java.util.Scanner
import scala.collection.mutable

object Main extends App {
  val sc: Scanner = new Scanner(System.in)
  val MOD = 1000000007

  val N = sc.nextInt
  val S = sc.next

  val dp = mutable.IndexedSeq.fill(S.length + 10, 10)(0L)
  dp(0)(0) = 1
  for (i <- 0 until S.length) {
    for (j <- 0 to 7) {
      dp(i + 1)(j) += dp(i)(j)
      if (S(i) == 'a' && j == 0 ||
        S(i) == 't' && j == 1 ||
        S(i) == 'c' && j == 2 ||
        S(i) == 'o' && j == 3 ||
        S(i) == 'd' && j == 4 ||
        S(i) == 'e' && j == 5 ||
        S(i) == 'r' && j == 6
      ) dp(i + 1)(j + 1) = dp(i)(j)
    }
    for (j <- 0 to 7) {
      dp(i + 1)(j) %= MOD
    }
  }

  println(dp(S.length)(7))
}
