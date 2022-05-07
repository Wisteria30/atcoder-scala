import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val a, b, c = BigInt(sc.nextLong)

  val cube = a.gcd(b).gcd(c)
  println((a / cube - 1) + (b / cube - 1) + (c / cube - 1))
  
}
