import java.util.Scanner
import scala.annotation.tailrec

object Main extends App {
  val sc: Scanner = new Scanner(System.in)
  val BORDER = 1000000000000000000L
  val a, b = BigInt(sc.nextLong)

  val lcm = a * b / gcd(a, b)
  if (lcm > BORDER) println("Large")
  else println(lcm)

  @tailrec
  def gcd(x: BigInt, y: BigInt): BigInt = if (y == 0) x else gcd(y, x % y)
}
