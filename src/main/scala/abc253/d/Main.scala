import java.util.Scanner
import scala.annotation.tailrec

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val N, A, B = BigInt(sc.nextInt)
  val sumN = N * (N + 1) / 2
  val lcmAB = A * B / gcd(A, B)
  val divNA = N / A
  val sumA = A * divNA * (divNA + 1) / 2
  val divNB = N / B
  val sumB = B * divNB * (divNB + 1) / 2
  val divNlcmAB = N / lcmAB
  val sumLcmAB = lcmAB * divNlcmAB * (divNlcmAB + 1) / 2
  
  val ans = sumN - sumA - sumB + sumLcmAB
  println(ans)

  @tailrec
  def gcd(a: BigInt, b: BigInt): BigInt = if (b == 0) a else gcd(b, a % b)
}
