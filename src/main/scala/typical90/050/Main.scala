import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)
  val MOD = 1000000007

  val N, L = sc.nextInt
  val divide = N / L
  var ans = 1L

  for (i <- 1 to divide) {
    val n = N - i * (L - 1)
    ans += c(n, i)
    ans %= MOD
  }
  println(ans)

  def c(n: Long, r: Long): Long = {
    if (r == 0) return 1
    var bunbo = BigInt(1)
    var bunshi = BigInt(1)
    for (i <- 0L until r) {
      bunshi *= (n - i)
      bunbo *= (i + 1)
    }
    ((bunshi / bunbo) % MOD).toLong
  }
}
