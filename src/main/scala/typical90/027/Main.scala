import java.io.PrintWriter
import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)
  val pw = new PrintWriter(System.out)

  val n = sc.nextInt
  var user_names = Set[String]()
  for (i <- 1 to n) {
    val s = sc.next
    if (!user_names.contains(s)) {
      user_names += s
      pw.println(i)
    }
  }
  pw.flush()
}
