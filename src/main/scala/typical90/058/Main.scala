import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)
  val MOD = 100000

  val N, K = sc.nextLong
  val visited = Array.fill[Boolean](MOD)(false)

  val cycle = Array.fill(MOD)(-1)

  var x = calcZ(N.toInt)
  var cnt = 0
  while (!visited(x)) {
    visited(x) = true
    cycle(cnt) = x
    x = calcZ(x)
    cnt += 1
  }
  val loopStart = cycle.indexOf(calcZ(cycle(cnt- 1)))
  val loop = cnt - loopStart
  val nonLoop = cnt - loop

  if (K <= nonLoop) println(cycle((K - 1).toInt))
  else println(cycle(((K - 1 - nonLoop) % loop + nonLoop).toInt))

  def calcZ(x: Int): Int = {
    val y = x.toString.toCharArray.map(_ - '0').sum
    (x + y) % MOD
  }
}
