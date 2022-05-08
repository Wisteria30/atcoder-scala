import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val h, w = sc.nextInt
  if (h == 1 || w == 1) {
    println(h * w)
  } else {
    val ans = ((h + 1) / 2) * ((w + 1) / 2)
    println(ans)
  }
}
