val g = List(
   List((1, 1), (2, 3), (4, 10)),
   List((2, 1)),
   List((3, 1), (4, 5)),
   List((4, 1)),
   List())


def enumPaths: (List[List[(Int, Int)]], List[(Int, Int)], Int, Int) => List[Int] = (als, rs, d, n) => {
    val costList = for (u <- rs if (u._1 == d)) yield u._2
    val g = for (x <- rs; y <- als(x._1)) yield (y._1, x._2 + y._2)
    if (n == 0) {
      costList
    } else {
      costList ::: enumPaths(als, g, d, n - 1)
    }
  }



def pathsWithMaxCost: (List[List[(Int, Int)]], Int, Int, Int) => Int => Boolean = (als, s, d, c) => n => {
  // enumPaths(als, List((s, 0)), d, n).exists(_ <= c)
  enumPaths(als, List((s, 0)), d, n).filter(_ <= c).size > 0
}


def binarySearch: (Int => Boolean) => (Int, Int) => Int = f => (l, h) => {
  val mitte = l + ((h - l) / 2)
  if (l >= h) {
    h
  } else if (f(mitte)) {
    binarySearch(f)(l, mitte)
  } else {
    binarySearch(f)(mitte+1, h)
  }
}