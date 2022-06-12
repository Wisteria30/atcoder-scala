import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val dx = Array(1, 0, -1, 0)
  val dy = Array(0, 1, 0, -1)

  val H, W = sc.nextInt
  val field = Array.ofDim[Char](20, 20)
  val used = Array.ofDim[Boolean](20, 20)

  for (h <- 1 to H) {
    val c = sc.next
    for (w <- 0 until W) {
      field(h)(w + 1) = c(w)
    }
  }

  var ans = -1
  for (y <- 1 to H) {
    for (x <- 1 to W) {
      ans = ans max dfs(x, y, x, y)
    }
  }
  if (ans <= 2) ans = -1
  println(ans)

  def dfs(sx: Int, sy: Int, px: Int, py: Int): Int = {
    if (sx == px && sy == py && used(py)(px)) return 0
    used(py)(px) = true

    var ret = -10000
    for (i <- 0 until 4) {
      (px + dx(i), py + dy(i)) match {
        case (nx, ny) if nx < 1 || nx > W || ny < 1 || ny > H =>
        case (nx, ny) if field(ny)(nx) == '#' =>
        case (nx, ny) if (sx != nx || sy != ny) && used(ny)(nx) =>
        case (nx, ny) =>
          val v = dfs(sx, sy, nx, ny)
          ret = ret max (v + 1)
      }
    }
    used(py)(px) = false
    ret
  }
}
