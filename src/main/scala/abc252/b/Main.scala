import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val N, K = sc.nextInt
  val A = IndexedSeq.fill(N)(sc.nextInt)
  val maxA = A.max
  val B = Set.fill(K)(sc.nextInt - 1)
  val maxAIndeies = A.zipWithIndex.filter(x => maxA == x._1).map(_._2)
  val ans = maxAIndeies.foldLeft(false)((acc, x) => acc || B.contains(x))
  println(if (ans) "Yes" else "No")
}
