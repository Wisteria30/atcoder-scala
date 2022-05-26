import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)
  val MOD = 1000000007

  val N, K = sc.nextLong
  if (N == 1) {
    println(K % MOD)
  } else if (N == 2) {
    println(K * (K - 1) % MOD)
  } else {
    println(K * (K - 1) * BigInt(K - 2).modPow(N - 2, MOD) % MOD)
  }
}
