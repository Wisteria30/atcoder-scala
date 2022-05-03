import java.util.Scanner

object Main extends App {
  val sc = new Scanner(System.in)
  val N = sc.nextInt()

  val graph = Array.fill(N)(IndexedSeq[Int]())
  for (i <- 0 until N - 1) {
    val a, b = sc.nextInt()
    graph(a - 1) = graph(a - 1) :+ b - 1
    graph(b - 1) = graph(b - 1) :+ a - 1
  }

  val maxNode = bfs(0)._1
  println(bfs(maxNode)._2 + 1)

  // bfs
  def bfs(start: Int): (Int, Int) = {
    val queue = new scala.collection.mutable.Queue[Int]()
    val costs = Array.fill(N)(-1)
    queue.enqueue(start)
    costs(start) = 0

    while (queue.nonEmpty) {
      val cur = queue.dequeue()
      for (i <- graph(cur)) {
        if (costs(i) == -1) {
          costs(i) = costs(cur) + 1
          queue.enqueue(i)
        }
      }
    }
    (costs.indices.maxBy(costs), costs.max)
  }
}