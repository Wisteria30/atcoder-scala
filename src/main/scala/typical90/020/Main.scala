import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)
  val INF = 1000000007

  val a, b, c = sc.nextLong

  val bc = (0 until b.toInt).foldLeft(1L)((acc, _) => acc * c)
  if (a < bc) {
    println("Yes")
  } else {
    println("No")
  }
}
