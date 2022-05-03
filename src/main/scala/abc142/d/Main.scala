import java.util.Scanner
import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val A, B = sc.nextLong
  // 約数の集合
  val div = divisors(gcd(A, B)).distinct.sorted.drop(1)
  val ans = ArrayBuffer[Long]()
  for (i <- div) {
    if (!ans.exists(i % _ == 0)) ans += i
  }

  // 最大公約数
  @tailrec
  def gcd(a: Long, b: Long): Long = if (b == 0) a else gcd(b, a % b)

  // 約数列挙
  def divisors(n: Long): List[Long] = {
    @tailrec
    def loop(n: Long, x: Long, acc: List[Long]): List[Long] = {
      if (x * x > n) acc
      else if (n % x == 0) loop(n, x + 1, n / x :: x :: acc)
      else loop(n, x + 1, acc)
    }

    loop(n, 1, Nil)
  }

  println(ans.length + 1)
}
