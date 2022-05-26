import java.util.Scanner

object Main extends App {
  val sc: Scanner = new Scanner(System.in)

  val N = sc.nextInt
  val A = IndexedSeq.fill(N)(sc.nextLong)
  val totalA: Long = A.sum
  val AA = A ++ A
  var ans: Boolean = false

  //尺取り法
  var left = 0
  var right = 0
  var sum = 0L
  while (right < AA.size) {
    while (sum * 10 < totalA && right < AA.size) {
      sum += AA(right)
      if (sum * 10 == totalA) {
        ans = true
      }
      right += 1
    }
    //    println(left + " " + right)
    //    println(sum)
    while (sum * 10 >= totalA && left < right) {
      sum -= AA(left)
      if (sum * 10 == totalA) {
        ans = true
      }
      left += 1
    }

  }
  if (ans) {
    println("Yes")
  } else {
    println("No")
  }
}
