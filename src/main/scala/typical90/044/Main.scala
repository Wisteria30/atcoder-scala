import java.util.Scanner
import scala.collection.mutable

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val n, q = sc.nextInt
  val A = mutable.IndexedSeq.fill(n)(sc.nextInt)
  val MOD = A.size
  var rotationCount = 0
  for (_ <- 0 until q) {
    val t, x, y = sc.nextInt
    t match {
      case 1 =>
        val modX = ((x - 1) + rotationCount) % MOD
        val modY = ((y - 1) + rotationCount) % MOD
        val tmp = A(modX)
        A(modX) = A(modY)
        A(modY) = tmp
      case 2 =>
        rotationCount = (rotationCount + MOD - 1) % MOD
      case 3 =>
        val modX = ((x - 1) + rotationCount) % MOD
        println(A(modX))
    }
  }
}
