/* Reduction */

// sum(List(x1, ..., xn)) = x1 + ... + xn

// recursive solution
def sumList(xs: List[Int]): Int = {
  xs match {
    case Nil => 0
    case h :: t => h + sumList(t)
  }
}

// reduceLeft
def sumList2(xs: List[Int]): Int = {
  xs.reduceLeft((x, y) => x + y)
}

// in this example, reducing right or left doesn't matter because the operation is associative
// however, for non-associative operations this would matter


// foldLeft: reduceLeft is defined i.t.o a more general function, foldLeft
// foldLeft takes an accumulator which is returned when foldLeft is called on Nil
// foldLeft signature: foldLeft[T](xs: List[T], accumulator: T)(operation: (T, T) => T)
val l0 = List(1, 2, 3)
l0.foldLeft(1)((x, y) => x * y)  // product
l0.foldLeft(0)((x, y) => x + y)  // sum


// the Right variations of reduce and fold are analogous, but begin to perform operations starting from the tail
// i.e. the final operation is combining x1 and the concatenated result of x2 ... xn
// reduceRight
// foldRight

// in this example, foldLeft would not work as it would begin with the illegal operation ys :: 1
def concat[T](xs: List[T], ys: List[T]): List[T] = {
  xs.foldRight(ys)((x, y) => x :: y)
}
concat(List(1, 2, 3), List(4, 5, 6))