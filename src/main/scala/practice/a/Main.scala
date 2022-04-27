package practice.a

import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)
  val a: Int = sc.nextInt
  val an: Array[Int] = Array.fill(2)(sc.nextInt)
  val s: String = sc.next
  println(s"${a + an.sum} $s")
}
