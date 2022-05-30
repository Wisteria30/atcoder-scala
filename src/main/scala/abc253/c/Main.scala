import java.util.Scanner
import scala.collection.mutable

object Main extends App {
  val sc: Scanner = new Scanner(System.in)
  val INF = 1000000007

  val Q = sc.nextInt
  val pq_max = mutable.PriorityQueue[Int]()(Ordering.Int)
  val pq_min = mutable.PriorityQueue[Int]()(Ordering.Int.reverse)
  val sMap = mutable.Map[Int, Int]()
  val eraseX_max = mutable.Map[Int, Int]()
  val eraseX_min = mutable.Map[Int, Int]()
  for (_ <- 0 until Q) {
    val t = sc.nextInt
    t match {
      case 1 =>
        val x = sc.nextInt
        pq_max.enqueue(x)
        pq_min.enqueue(x)
        sMap(x) = sMap.getOrElse(x, 0) + 1
      case 2 =>
        val x = sc.nextInt
        val c = sc.nextInt
        eraseX_max += (x -> math.min(eraseX_max.getOrElse(x, 0) + c, sMap.getOrElse(x, 0)))
        eraseX_min += (x -> math.min(eraseX_min.getOrElse(x, 0) + c, sMap.getOrElse(x, 0)))
      case 3 =>
        while (eraseX_max.getOrElse(pq_max.head, 0) > 0) {
          eraseX_max(pq_max.head) -= 1
          pq_max.dequeue()
        }
        while (eraseX_min.getOrElse(pq_min.head, 0) > 0) {
          eraseX_min(pq_min.head) -= 1
          pq_min.dequeue()
        }
        println(pq_max.head - pq_min.head)
    }
  }
}
