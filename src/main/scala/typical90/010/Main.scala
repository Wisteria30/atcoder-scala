import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val n = sc.nextInt
  val classes = Array.ofDim[Int](2, n)

  for (i <- 0 until n) {
    val c, p = sc.nextInt
    classes(c - 1)(i) = p
  }
  val imosu = Array.ofDim[Int](2, n + 10)
  for (c <- 0 to 1) {
    for (i <- 0 until n) {
      imosu(c)(i + 1) = imosu(c)(i) + classes(c)(i)
    }
  }

  val q = sc.nextInt
  for (_ <- 0 until q) {
    val l, r = sc.nextInt
    val l_ans = imosu(0)(r) - imosu(0)(l - 1)
    val r_ans = imosu(1)(r) - imosu(1)(l - 1)
    println(s"${l_ans} ${r_ans}")
  }
}
