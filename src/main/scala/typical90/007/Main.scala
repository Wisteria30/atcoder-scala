import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val n = sc.nextInt
  val a = IndexedSeq.fill(n)(sc.nextInt).sorted
  val q = sc.nextInt

  (0 until q).foreach { _ =>
    val b = sc.nextInt
    val idx = meguruBisect(a.size, 0, b)
    val ans = math.min(math.abs(a(idx) - b), math.abs(a(math.min(idx + 1, a.size - 1)) - b))
    println(ans)
  }

  def meguruBisect(ng: Int, ok: Int, tgt: Int): Int = {
    var ok_ = ok
    var ng_ = ng
    while (math.abs(ok_ - ng_) > 1) {
      val mid = (ok_ + ng_) / 2
      if (isOK(tgt, mid)) {
        ok_ = mid
      } else {
        ng_ = mid
      }
    }
    ok_
  }

  def isOK(tgt: Int, x: Int): Boolean = {
    a(x) <= tgt
  }
}
