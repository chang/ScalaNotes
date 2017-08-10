/* Basic List operations */

// Lists are immutable and recursive (unlike Arrays, which are flat)
val fruitList = List("apples", "oranges", "pears")

// All lists are constructed from the empty list Nil, and :: (cons)
val l0 = 1 :: 2 :: 3 :: Nil  // List[Int] = List(1, 2, 3)

// Operators ending in ":" are special, in that they associate to the right,
// and when used in infix notation, are seen as method calls of the right hand operator instead of the left
val l1 = Nil.::(3).::(2).::(1)  // List[Int] = List(1, 2, 3)

l0.head  // Int = 1
l0.tail  // List[Int] = List(2, 3)
l0.isEmpty  // false

// :: is like Python's append()
l0 :: l1   // List[Any] = List(List(1, 2, 3), 1, 2, 3)

// ::: is like extend() or +
l0 ::: l1  // List[Int] = List(1, 2, 3, 1, 2, 3)


/* Pattern matching Lists */

val l3 = List(1, 2, List('a', 'b'), 4, 5, 6, 7)

// Lists match patterns using constructor notation
l3 match {
  case List(x) => "List of length 1"
  case x :: Nil => "Alternative list of length one"
  case List(x, y, z) => "List of length 3"
  case 1 :: tail => "List that starts with 1"
  case e0 :: e1 :: List(x, y) :: tail => "\nElements 1 and 2: %s, %s \nInternal List: List(%s, %s) \nTail: %s".format(e0, e1, x, y, tail)
}

/* Functional insertion sort */
val unsortedList = List(10, 3, 1, 6, 5, 2)

def insertionSort(l: List[Int]): List[Int] = {
  l match {
    case List() => List()
    case head :: tail => insert(head, insertionSort(tail))
  }
}

def insert(x: Int, xs: List[Int]): List[Int] = {
  xs match {
    case List() => List(x)
    case h :: t => if (x <= h) x :: xs else h :: insert(x, t)
  }
}

insertionSort(unsortedList)