import java.util.Scanner
import scala.collection.mutable.ArrayBuffer

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val K = sc.nextLong
  val divisors = enumDivisors(K)
  var ans = 0
  for (iIndex <- divisors.indices) {
    for (jIndex <- iIndex until divisors.length) {
      val i = divisors(iIndex)
      val j = divisors(jIndex)
      if ((K / i) < j) {}
      else if ((K / i) % j != 0L) {}
      else if (j <= (K / i / j)) ans += 1
    }
  }
  println(ans)


  def enumDivisors(N: Long): ArrayBuffer[Long] = {
    val res = ArrayBuffer.empty[Long]
    var i = 1L
    while(i * i <= N) {
      if (N % i == 0) {
        res += i
        if (N / i != i) res += N / i
      }
      i += 1
    }
    res.sorted
  }
}
