import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val N = sc.nextInt
  var Xs, Ys = Array.fill(N)(0L)
  for (i <- 0 until N) {
    val x, y = sc.nextLong
    Xs(i) = x
    Ys(i) = y
  }
  Xs = Xs.sorted
  Ys = Ys.sorted
  val energyX = if (N % 2 == 0) math.round((Xs(N / 2 - 1) + Xs(N / 2)) / 2.0) else Xs(N / 2)
  val energyY = if (N % 2 == 0) math.round((Ys(N / 2 - 1) + Ys(N / 2)) / 2.0) else Ys(N / 2)

  var ans = 0L
  for (i <- 0 until N) {
    ans += math.abs(Xs(i) - energyX) + math.abs(Ys(i) - energyY)
  }
  println(ans)
}
