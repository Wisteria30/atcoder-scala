import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val n, k = sc.nextInt
  val a = Array.fill(n)(sc.nextInt)
  val b = Array.fill(n)(sc.nextInt)
  var diff = BigInt(0)
  for (i <- 0 until n) {
    diff += Math.abs(a(i) - b(i))
  }
  if (diff > k) {
    println("No")
  } else if ((k - diff) % 2 == 0) {
    println("Yes")
  } else {
    println("No")
  }
}
