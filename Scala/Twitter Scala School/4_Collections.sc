/* DATA STRUCTURES */

/* Array */
// Mutable, ordered
val arr = Array(1, 2, 3, 4, 5)
arr(0)
arr.length


/* List */
// Immutable, ordered
val list = List(1, 2, 3, 4)
list(1)
list.length
list.head
list.tail


/* Set */
// Can choose immutable or mutable
// All elements same type
val set = Set(1, 1, 1, 2, 3)
val setExplicit: Set[Int] = Set(1, 2, 3)


/* Tuple */
// Immutable, can have different types
// Weird syntax for accessing elements and 1-based indexing
// Fun fact: starting with 1 is a tradition set by other languages
//           with statically typed tuples, such as Haskell
val tuple = (12, "foobar", 1.1, 'a')
tuple._1

val tupleExplicit: (Int, String) = (5, "hello")
tupleExplicit._2

// Note that .productElement(n) can access tuples in the usual way,
// and in 0-base indexing, but we lose the type info as return is of type Any
tupleExplicit.productElement(0)

// pattern matching very useful with tuples
def checkFavoriteThings(x: (Int, String)) = {
  x match {
    case (8, "cream colored ponies") => "Those are my favorite things!"
    case (13, "rusty nails") => "Those are the worst things"
    case _ => "Those are not my favorite things"
  }
}

checkFavoriteThings(8, "cream colored ponies")
checkFavoriteThings((13, "rusty nails"))
checkFavoriteThings((12, "soggy apple strudel"))

// syntactic sugar for tuple of arity 2
val t1 = 1 -> 2
val t2 = 'a' -> "abc"


/* Maps */
var map = Map(1 -> "one", 2 -> "two")
map += (100 -> "one hundred")
map(100)

for (key <- map.keys)
  printf("key: %s value: %s\n", key, map(key))

val x = 'L