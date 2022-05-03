import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val N: Int = sc.nextInt
  val ans: Double = (N - N / 2).asInstanceOf[Double] / N
  println(f"$ans%.10f")
}
