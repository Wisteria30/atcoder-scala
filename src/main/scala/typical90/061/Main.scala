import java.io.PrintWriter
import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)
  val pw = new PrintWriter(System.out)

  val q = sc.nextInt
  var deck = Vector[Int]()
  for (i <- 0 until q) {
    val t, x = sc.nextInt
    t match {
      case 1 => deck +:= x
      case 2 => deck :+= x
      case 3 => pw.println(deck(x - 1))
    }
  }
  pw.flush()
}
