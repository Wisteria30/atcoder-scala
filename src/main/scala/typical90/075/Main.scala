import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val N = sc.nextLong
  val pf = primeFactors(N)
  val log2 = (x: Int) => math.log(x) / math.log(2)
  if (pf.size == 1 && pf.head == N) println(0)
  else println(math.ceil(log2(pf.size)).toInt)

  //  素因数分解
  def primeFactors(n: Long): List[Long] = {
    var ret: List[Long] = Nil
    var _n = n
    var i = 2L
    while (i * i <= n) {
      if (_n % i == 0) {
        ret = i :: ret
        _n /= i
      } else {
        i += 1
      }
    }
    if (_n > 1) {
      ret = _n :: ret
    }
    ret
  }
}
