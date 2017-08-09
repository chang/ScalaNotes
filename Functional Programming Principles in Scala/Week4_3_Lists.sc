/* Lists */

// Lists are immutable and recursive (unlike Arrays, which are flat)
val fruitList = List("apples", "oranges", "pears")

// All lists are constructed from the empty list Nil, and :: (cons)
val l0 = 1 :: 2 :: 3 :: Nil  // List[Int] = List(1, 2, 3)

// Operators ending in ":" are special, in that they associate to the right,
// and when used in infix notation, are seen as method calls of the right hand operator instead of the left
val l1 = Nil.::(3).::(2).::(1)  // List[Int] = List(1, 2, 3)


l0.head  // Int = 1
l0.tail  // List[Int] = List(2, 3)