import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val abc = IndexedSeq.fill(3)(sc.nextInt)
  val sorted_abc = abc.sorted
  if (sorted_abc(1) == abc(1)) {
    println("Yes")
  } else {
    println("No")
  }
}
