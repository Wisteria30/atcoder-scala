import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val N: Int = sc.nextInt
  val A: Array[Int] = Array.fill(N)(sc.nextInt)
  // Pair型のArrayを作成
  val a_n: Array[(Int, Int)] = A.zipWithIndex.map { case (a, i) => (a, i + 1) }.sortBy(_._1)

  val ans: String = a_n.map(_._2).mkString(" ")
  println(ans)
}
