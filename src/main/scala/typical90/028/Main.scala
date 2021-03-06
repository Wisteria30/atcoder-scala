import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val H = 1010
  val W = 1010

  val N = sc.nextInt
  val tiles = Array.fill(H, W)(0)
  for (_ <- 0 until N) {
    val A, C, B, D = sc.nextInt
    tiles(C)(A) += 1
    tiles(C)(B) -= 1
    tiles(D)(A) -= 1
    tiles(D)(B) += 1
  }

  for (y <- 0 until H) {
    for (x <- 1 until W) {
      tiles(y)(x) += tiles(y)(x - 1)
    }
  }

  for (y <- 1 until H) {
    for (x <- 0 until W) {
      tiles(y)(x) += tiles(y - 1)(x)
    }
  }

  val ks = Array.fill(N + 1)(0)
  for (y <- 0 until H) {
    for (x <- 0 until W) {
      ks(tiles(y)(x)) += 1
    }
  }
  
  println(ks.drop(1).mkString("\n"))
}
