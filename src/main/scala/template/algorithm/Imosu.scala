package template.algorithm

object Imosu {
  val H, W = 1010
  val N = 1000
  val A, B, C, D = 100

  val tiles = Array.fill(H, W)(0)
  for (_ <- 0 until N) {
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
// 加工例
//  val ks = Array.fill(N + 1)(0)
//  for (y <- 0 until H) {
//    for (x <- 0 until W) {
//      ks(tiles(y)(x)) += 1
//    }
//  }
//
//  println(ks.drop(1).mkString("\n"))
}
