import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val h, w = sc.nextInt
  val field = Array.fill(h, w)(sc.nextInt)
  val h_sum = field.map(_.sum)
  val w_sum = field.transpose.map(_.sum)
  val ans = Array.ofDim[Int](h, w)
  (0 until h).foreach { i =>
    (0 until w).foreach { j =>
      ans(i)(j) = h_sum(i) + w_sum(j) - field(i)(j)
    }
  }
  println(ans.map(_.mkString(" ")).mkString("\n"))
}
