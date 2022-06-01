package template.structure

import scala.collection.mutable

class UnionFind(sz: Int) {
  private val data = mutable.IndexedSeq.fill(sz)(-1)

  def unite(x: Int, y: Int): Boolean = {
    val xRoot = find(x)
    val yRoot = find(y)
    if (xRoot == yRoot) return false
    if (data(xRoot) < data(yRoot)) {
      data(xRoot) += data(yRoot)
      data(yRoot) = xRoot
    } else {
      data(yRoot) += data(xRoot)
      data(xRoot) = yRoot
    }
    true
  }

  @annotation.tailrec
  final def find(k: Int): Int = {
    if (data(k) < 0) k
    else find(data(k))
  }

  def size(k: Int): Int = {
    -data(find(k))
  }

  def same(x: Int, y: Int): Boolean = {
    find(x) == find(y)
  }

  def groups(): mutable.IndexedSeq[mutable.IndexedSeq[Int]] = {
    val ret = mutable.IndexedSeq.fill(data.size)(mutable.IndexedSeq.empty[Int])
    for (i <- data.indices) {
      ret(find(i)) :+= i
    }
    ret.filter(_.nonEmpty)
  }
}
