import java.util.Scanner
import scala.collection.mutable

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val N = sc.nextInt
  val S = sc.next
  //  ('o', 0)
  val queue = mutable.Queue[Char]()
  val oxPair = mutable.ArrayBuffer[Int]()
  for (i <- 0 until N) {
    while (queue.nonEmpty && queue.head != S(i)) {
      queue.dequeue()
      oxPair += i
    }
    queue.enqueue(S(i))
  }
  if (oxPair.isEmpty) {
    println(0)
  } else {
    val ans = oxPair.foldLeft(BigInt(0))((acc, i) => acc + (N - i))
    println(ans)
  }
}
