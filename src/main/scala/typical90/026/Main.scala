import java.util.Scanner
import scala.collection.mutable

object Main extends App {
  val sc = new Scanner(System.in)

  val N = sc.nextInt
  val graph = Array.fill(N)(List.empty[Int])
  for (_ <- 0 until N - 1) {
    val A, B = sc.nextInt - 1
    graph(A) = B :: graph(A)
    graph(B) = A :: graph(B)
  }

  val queue = mutable.Queue.empty[Int]

  val twoColors = Array.fill(N)(-1)
  twoColors(0) = 0
  queue.enqueue(0)

  while (queue.nonEmpty) {
    val edge = queue.dequeue()
    val nextColor = 1 - twoColors(edge)
    for (next <- graph(edge)) {
      if (twoColors(next) == -1) {
        twoColors(next) = nextColor
        queue.enqueue(next)
      }
    }
  }

  val zeros = twoColors.zipWithIndex.filter(_._1 == 0).map(_._2 + 1)
  val ones = twoColors.zipWithIndex.filter(_._1 == 1).map(_._2 + 1)

  if (zeros.length >= ones.length) {
    println(zeros.slice(0, N / 2).mkString(" "))
  } else {
    println(ones.slice(0, N / 2).mkString(" "))
  }
}
