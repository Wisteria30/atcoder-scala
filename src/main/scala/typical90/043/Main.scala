import java.util.Scanner
import scala.collection.mutable

object Main extends App {
  val sc: Scanner = new Scanner(System.in)
  val INF = 1000000007

  val H, W = sc.nextInt
  val field = Array.fill(H, W)('#')
  val start_y, start_x, goal_y, goal_x = sc.nextInt - 1

  for (j <- 0 until H) {
    val s = sc.next
    for (i <- 0 until W) {
      field(j)(i) = s(i)
    }
  }
  val scores = Array.fill(H, W)(INF)
  // 右, 下, 左, 上
  val dx = Array(1, 0, -1, 0)
  val dy = Array(0, 1, 0, -1)

  // y, x, 前の方向, 前のスコア
  val queue = mutable.ArrayDeque.empty[(Int, Int, Int, Int)]
  queue.append((start_y, start_x, -1, 0))
  scores(start_y)(start_x) = 0

  while(queue.nonEmpty) {
    val (y, x, prevDirection, prevCost) = queue.removeFirst(_ => true).getOrElse((-1, -1, -1, -1))
    // 同じ位置からは再訪問できない
    if (scores(y)(x) < prevCost) {}
    else {
      for (i <- 0 until 4) {
        val ny = y + dy(i)
        val nx = x + dx(i)
        if (ny < 0 || ny >= H || nx < 0 || nx >= W) {}
        else if (field(ny)(nx) == '#') {}
        else if (field(ny)(nx) == '.') {
          val cost = prevCost + {if (i == prevDirection) 0 else 1}
          if (scores(ny)(nx) >= cost) {
            scores(ny)(nx) = cost
            if (cost == prevCost) queue.prepend((ny, nx, i, cost))
            else queue.append((ny, nx, i, cost))
          }
        }
      }
    }
  }

  println(scores(goal_y)(goal_x) - 1)
}
