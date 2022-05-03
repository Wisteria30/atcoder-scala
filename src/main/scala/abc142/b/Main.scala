import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val N: Int = sc.nextInt
  val K: Int = sc.nextInt
  val hn: Array[Int] = Array.fill(N)(sc.nextInt)

  val ans = hn.count(_ >= K)
  println(ans)
}
