/* Patterns for performing common list operations */

// transform each element of a list in a certain way (map)
// retrieving a list of elements satisfying a condition (filter)
// combining the elements of a list using an operator


// map

// recursive solution
def squareList(xs: List[Int]): List[Int] = {
  xs match {
    case List() => List()
    case h :: t => h * h :: squareList(t)
  }
}

// map solution
def squareList2(xs: List[Int]) = xs.map((x: Int) => x * x)


// filter

// recursive solution
def filterEquals(xs: List[Int], num: Int): List[Int] = {
  xs match {
    case List() => List()
    case h :: t => if (h == num) h :: filterEquals(t, num) else filterEquals(t, num)
  }
}

// filter solution
def filterEquals2(xs: List[Int], num: Int) = {
  xs.map(x => x == num)
}


// other list subsetting functions
// filterNot
// partition
// takeWhile
// dropWhile
// span


// write a function pack that packs consecutive duplicates of list elements into sublists
val l1 = List(1, 1, 1, 5, 5, 8, 8, 8, 8)

def pack(xs: List[Any]): List[Any] = {
  def equalsHead = (x: Any) => x == xs.head
  xs match {
    case Nil => Nil
    case h :: t => (List(h) ++ t.takeWhile(equalsHead)) :: pack(t.dropWhile(equalsHead))
  }
}
pack(l1)