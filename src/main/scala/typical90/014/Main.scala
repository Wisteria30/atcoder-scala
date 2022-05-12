import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val n = sc.nextInt
  val a = IndexedSeq.fill(n)(sc.nextLong).sorted
  val b = IndexedSeq.fill(n)(sc.nextLong).sorted

  val ans = a.zip(b).map { case (a, b) => math.abs(a - b) }.sum
  println(ans)
}
