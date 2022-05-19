import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val mod = 46
  val n: Int = sc.nextInt
  val A = IndexedSeq.fill(n)(sc.nextInt % mod).groupMapReduce(identity)(_ => 1)(_ + _)
  val B = IndexedSeq.fill(n)(sc.nextInt % mod).groupMapReduce(identity)(_ => 1)(_ + _)
  val C = IndexedSeq.fill(n)(sc.nextInt % mod).groupMapReduce(identity)(_ => 1)(_ + _)
  var ans = for {
    a <- A
    b <- B
    c <- C
    if (a._1 + b._1 + c._1) % mod == 0
  } yield BigInt(a._2) * b._2 * c._2
  println(ans.toSeq.sum)
}
