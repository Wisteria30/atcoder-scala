import java.util.Scanner
import scala.collection.mutable

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val N, K = sc.nextInt
  val As = Array.fill(N)(sc.nextInt) ++ Array(-1)
  val runLengthAs = mutable.ArrayBuffer.empty[(Int, Int)]

  var s = -1
  var cnt = 0
  for (i <- As.indices) {
    if (s != As(i)) {
      if (cnt > 0) {
        runLengthAs += ((s, cnt))
      }
      s = As(i)
      cnt = 1
    } else if (As(i) == s) {
      cnt += 1
    }
  }

  val inK = mutable.Map[Int, Int]()
  var ans = 0
  cnt = 0
  val queue = mutable.ArrayDeque.empty[(Int, Int)]
  for (i <- runLengthAs.indices) {
    val asCnt = runLengthAs(i)
    queue.append(asCnt)
    cnt += asCnt._2
    inK += (asCnt._1 -> (inK.getOrElse(asCnt._1, 0) + asCnt._2))

    while (queue.nonEmpty && inK.size > K) {
      val x = queue.removeFirst(_ => true).getOrElse((0, 0))
      inK(x._1) -= x._2
      if (inK(x._1) <= 0) {
        inK -= x._1
      }
      cnt -= x._2
    }
    ans = ans max cnt
  }

  println(ans)
}
