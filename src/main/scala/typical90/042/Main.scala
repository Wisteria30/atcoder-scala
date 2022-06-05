import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)
  val N = 100000
  val MOD = 1000000007

  val K = sc.nextInt
  if (!(K % 9 == 0)) {
    println(0)
    System.exit(0)
  }

  val dp = Array.fill(N)(0)
  dp(0) = 1
  for (i <- 1 to K) {
    for (j <- 1 to (i min 9)) {
      dp(i) += dp(i - j)
      dp(i) %= MOD
    }
  }
  println(dp(K))
}
