import java.util.Scanner

case class Point(x: Double, y: Double, z: Double) {
  def distance: Double = {
    math.sqrt(x * x + y * y + z * z)
  }
}

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val T = sc.nextDouble
  val L, x, y = sc.nextDouble
  val p_xyz = Point(x, y, 0)
  val q = sc.nextInt
  for (_ <- 0 until q) {
    val e = sc.nextDouble
    println("%.7f".format(solve(e)))
  }

  def solve(now: Double): Double = {
    val rDeg = now / T * 360
    val r_rad = math.toRadians(rDeg)
    val s_xyz = Point(
      0,
      -L / 2 * math.sin(r_rad),
      (L / 2) - (L / 2 * math.cos(r_rad))
    )
    val A = math.sqrt(math.pow(p_xyz.x, 2) + math.pow(s_xyz.y - p_xyz.y, 2))
    val B = s_xyz.z
    math.atan2(B, A).toDegrees
  }
}
