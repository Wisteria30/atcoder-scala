import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)
  val MOD = 1000000007

  val N = sc.nextInt
  val A = IndexedSeq.fill(N, 6)(sc.nextInt)
  var ans = BigInt(1)
  for (i <- 0 until N) {
    ans *= A(i).sum
    ans %= MOD
  }
  println(ans)
}