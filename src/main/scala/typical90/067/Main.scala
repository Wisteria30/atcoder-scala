import java.io.{BufferedReader, InputStream, InputStreamReader, PrintWriter}
import java.util.{Scanner, StringTokenizer}

class InputReader(stream: InputStream) {
  private val reader = new BufferedReader(new InputStreamReader(stream))
  private var tokenizer: StringTokenizer = new StringTokenizer(reader.readLine())

  def next(): String = {
    while (!tokenizer.hasMoreTokens) {
      tokenizer = new StringTokenizer(reader.readLine())
    }
    tokenizer.nextToken()
  }
}

object Main extends App {
  val sc: Scanner = new Scanner(System.in)
  val in = new InputReader(System.in)
  val pw = new PrintWriter(System.out)
  val n, k = in.next()
  var ans = n
  for (_ <- 1 to k.toInt) {
    ans = convertBase8to9(ans)
  }
  pw.println(ans)
  pw.flush()

  def convertBase8to9(n: String): String = {
    var base10 = 0L
    for (i <- n.reverse.zipWithIndex) {
      i match {
        case (c_num, exp) => base10 += c_num.asDigit * math.pow(8, exp).toLong
      }
    }

    var base9 = ""
    while (base10 > 0) {
      base9 += base10 % 9
      base10 /= 9
    }
    if (base9.isEmpty) "0"
    else base9.replace('8', '5').reverse.toLong.toString
  }
}
