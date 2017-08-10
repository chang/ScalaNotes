/* More functions on Lists */

val l0 = List(1, 2, "a", 3)

// Accessing and slicing
l0.length
l0.last  // This is O(n), like a linked list
l0.init  // List(1, 2, 'a')
l0 take 2  // List(1, 2)
l0 drop 2  // List('a', 3)
l0(2)  // 'a'

// Creating new lists
val l1 = List("acorn", "squirrel")
l0 ++ l1  // like :::
l1.reverse  // List("squirrel", "acorn")
l1 updated (1, "chipmunk")  // List("acorn", "chipmunk")

// Finding elements
l1 indexOf "squirrel"  // 1 (index of 1st element equal to "squirrel", or -1 if not present)
l1 contains "squirrel"


/* Implementing basic List ops*/

def init[T](x: List[T]): List[T] = x match {
  case List() => throw new Error("init of empty list")
  case List(e0) => List()
  case h :: t => h :: init(t)
}
// init is O(n)

def concat[T](x: List[T], y: List[T]): List[T] = {
  x match {
    case List() => y
    case h :: t => h :: concat(t, y)
  }
}
// concat is O(n)

def reverse[T](x: List[T]): List[T] = {
  x match {
    case List() => List()
    case h :: t => reverse(t) ++ List(h)
  }
}
// this implementation of reverse is O(n^2)

def removeAt[T](xs: List[T], n: Int) = {
  (xs take n) ::: (xs drop n + 1)
}