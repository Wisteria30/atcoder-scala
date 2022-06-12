import java.util.Scanner
import scala.collection.mutable

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val H, W = sc.nextInt
  val grid = Array.fill(H, W)(sc.nextInt)

  var ans = 0
  var bit = 0
  // bit全探索
  while(bit < (1<<H)) {
    val S = mutable.ArrayBuffer.empty[Int]
    for (i <- 0 until H) {
      if ((bit & (1<<i)) == (1<<i)) {
        S += i
      }
    }

    val m = mutable.Map.empty[Int, Int]
//    // maxとる
    for (w <- 0 until W) {
      var num = if (S.isEmpty) -1 else grid(S(0))(w)
      for (h <- S) {
        num = if (num != grid(h)(w)) -1 else num
      }
      if (num != -1) {
        m += num -> (m.getOrElse(num, 0) + S.length)
      }
    }
    if (m.nonEmpty) {
      ans = ans max m.maxBy{case (k, v) => v}._2
    }
    bit += 1
  }
  println(ans)
}
