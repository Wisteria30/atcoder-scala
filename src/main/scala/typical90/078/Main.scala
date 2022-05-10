import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val n, m = sc.nextInt
  val graph = Array.fill(n)(IndexedSeq[Int]())
  for (_ <- 1 to m) {
    var a, b = sc.nextInt
    a -= 1
    b -= 1
    if (b < a) graph(a) :+= b
    if (a < b) graph(b) :+= a
  }

  val ans = graph.foldLeft(0)(
    (acc, row) => {
      if (row.size == 1) acc + 1
      else acc
    }
  )
  println(ans)
}
