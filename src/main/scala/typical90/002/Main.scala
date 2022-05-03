import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val N = sc.nextInt


  if (N % 2 == 1) {
    println("")
  } else {
    var ans = List[String]()
    // ビット全探索
    for (bit <- 0 until (1 << N)) {
      var s = Array.ofDim[Char](N)
      for (i <- 0 until N) {
        if ((bit & (1 << i)) == 0) {
          s(i) = '('
        } else {
          s(i) = ')'
        }
      }
      if (check(s.mkString)) {
        ans = s.mkString :: ans
      }
    }
    ans.sorted.foreach(println)
  }

  def check(s: String): Boolean = {
    var lb, rb = 0
    for (c <- s) {
      if (c == '(') {
        lb += 1
      } else {
        rb += 1
      }
      if (lb < rb) {
        return false
      }
    }
    lb == rb
  }
}
