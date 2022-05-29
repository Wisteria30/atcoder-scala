import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)
  val MOD = 1000000007

  val L, R = BigInt(sc.nextLong)
  val ans = (solve(R) - solve(L - 1)) % MOD
  println(ans)


  def solve(N: BigInt): BigInt = {
    val pow10Int = (n: Double) => BigInt(math.pow(10, n).toLong)
    val digit = N.toString.length
    var ret = BigInt(0)
    for (i <- 0 until digit - 1) {
      val arithmetic = (pow10Int(i) + ("9" * (i + 1)).toLong) * 9 * pow10Int(i) / 2
      ret += (i + 1) * arithmetic
    }
    val arithmetic = (pow10Int(digit - 1) + N) * (N - pow10Int(digit - 1) + 1) / 2
    ret += digit * arithmetic
    ret
  }
}
