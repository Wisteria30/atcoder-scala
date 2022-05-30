import java.util.Scanner
import scala.collection.mutable

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val H, W = sc.nextInt
  val field = Vector.fill(H)(sc.next.toVector)

  var startEnd = mutable.ArrayBuffer[(Int, Int)]()
  for {
    i <- 0 until H
    j <- 0 until W
    if field(i)(j) == 'o'
  } {
    startEnd += ((i, j))
  }


  //  bfs
  var scores = mutable.IndexedSeq.fill(H, W)(-1)
  var q = new mutable.Queue[(Int, Int)]
  q += startEnd(0)
  scores(startEnd(0)._1)(startEnd(0)._2) = 0
  while (q.nonEmpty) {
    val (i, j) = q.dequeue()
    for {
      (di, dj) <- Seq((-1, 0), (1, 0), (0, -1), (0, 1))
      ni = i + di
      nj = j + dj
      if 0 <= ni && ni < H && 0 <= nj && nj < W
    } {
      if (scores(ni)(nj) == -1) {
        scores(ni)(nj) = scores(i)(j) + 1
        q += ((ni, nj))
      }
    }
  }
  println(scores(startEnd(1)._1)(startEnd(1)._2))
}
