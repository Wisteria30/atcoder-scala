import java.io.PrintWriter
import java.util.Scanner
import scala.math._

object Main extends App {
  val sc: Scanner = new Scanner(System.in)
  val pw = new PrintWriter(System.out)
  val INF = 1000000007

  val n = sc.nextLong
  val a, b, c = sc.nextLong
  val maxNumberCoin = 9999
  var ans = INF.toLong

  for {
    i <- 0 to maxNumberCoin
    j <- 0 to maxNumberCoin - i
  } {
    val last = n - a * i - b * j
    val cnt = i + j + last / c
    if (last % c == 0 && last >= 0 && cnt <= maxNumberCoin) {
      ans = min(ans, cnt)
    }
  }
  pw.println(ans)
  pw.flush()
}
