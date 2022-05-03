import java.util.Scanner
import scala.math._

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val INF = 1000000007

  val N, L, K = sc.nextInt
  val A = Array.fill(N)(sc.nextInt) ++ Array(L)

  val ans = meguruBisect(INF, 0)

  println(ans)

  def meguruBisect(ng: Int, ok: Int): Int = {
    var ok_ = ok
    var ng_ = ng
    while (abs(ok_ - ng_) > 1) {
      val mid = (ok_ + ng_) / 2
      if (isOK(mid)) {
        ok_ = mid
      } else {
        ng_ = mid
      }
    }
    ok_
  }


  // めぐる式二分探索
  def isOK(x: Int): Boolean = {
    var left = 0
    var split_num = 0
    for (a <- A) {
      if (a - left >= x) {
        left = a
        split_num += 1
      }
    }
    split_num >= K + 1
  }
}
