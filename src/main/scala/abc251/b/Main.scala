import java.io.PrintWriter
//import java.util.Scanner

object Main extends App {
  //  val sc: Scanner = new Scanner(System.in)
  val pw = new PrintWriter(System.out)
  val sc = Scanner

  val n, w = sc.nextInt()
  val a = IndexedSeq.fill(n)(sc.nextInt())
  var ans = collection.mutable.Set[Int]()
  for {
    i <- 0 until n
    j <- 0 until n
    k <- 0 until n
  } {
    var sum = a(i) + a(j) + a(k)
    if (i == j) sum -= a(j)
    if (i == k) sum -= a(k)
    if (j == k) sum -= a(k)
    if (i == j && j == k) sum += a(i)

    if (sum <= w) ans += sum
  }
  pw.println(ans.size)
  pw.flush()
}

object Scanner {
  private val buf = new Array[Byte](1024);
  private var ptr = 0;
  private var len = 0

  def nextInt(): Int = {
    val n = nextLong()
    if (n < Int.MinValue || Int.MaxValue < n) ???
    n.toInt
  }

  def nextLong(): Long = {
    if (!hasNext()) ???
    var minus = false;
    var b = readByte()
    if (b == '-') {
      minus = true;
      b = readByte()
    }

    def go(b: Byte, n: Long = 0): Long =
      if ('0' <= b && b <= '9') {
        go(readByte(), n * 10 + b - '0')
      }
      else if (minus) {
        -n
      } else {
        n
      }

    go(b)
  }

  @inline private def hasNext(): Boolean = {
    while (hasNextByte() && !isPrintableChar(buf(ptr))) ptr += 1
    hasNextByte()
  }

  @inline private def isPrintableChar(c: Int): Boolean = 33 <= c && c <= 126

  @inline private def hasNextByte(): Boolean =
    if (ptr >= len) {
      ptr = 0;
      len = System.in.read(buf);
      len > 0
    } else {
      true
    }

  @inline private def readByte(): Byte =
    if (hasNextByte()) {
      val res = buf(ptr);
      ptr += 1;
      res
    } else {
      -1
    }

  def nextDouble(): Double = next().toDouble

  def next(): String = {
    if (!hasNext()) ???
    val sb = new StringBuilder;
    var b = readByte()
    while (isPrintableChar(b)) {
      sb.append(b.toChar);
      b = readByte()
    }
    sb.toString
  }
}