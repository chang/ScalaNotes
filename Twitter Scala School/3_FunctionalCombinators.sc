/* Functional Combinators */

var arr = Array(1, 2, 3, 4, 5)
var list = List(6, 7, 8, 9, 10)

/* Map */
// Applies a function to each element of a collection
// returns the new collection
arr.map((x: Int) => x * x)

val double = (x: Int) => x * 2
val list_doubled = list.map(double)

/* foreach */
// Same as map, but intended for side effects only
// Returns Unit()
arr.map(double)

/* filter */
// removes any elements that evaluate to false
arr.filter((i: Int) => i > 3)

/* zip */
// aggregates two lists into a single list of tuples
val zipped = arr.zip(list)
val zip_element = zipped(0)
zip_element._1

/* partition */
// splits a list at the first place the expression evaluates to false
// return type is tuple
list.partition((x: Int) => x < 8)

/* drop */
// drops the first n elements
list.drop(3)

/* dropWhile */
// drops all elements that match a predicate until the first false
val arr2 = Array(10, 12, 21, 22, 24)
arr2.dropWhile((x: Int) => x % 2 == 0)

/* foldLeft(startIndex: Int)(2 element function) */
// starting index
// function: takes 2 values, first an accumulator, second the next element
// folded value must be of same type
arr
arr.foldLeft(0)((m: Int, n: Int) => m + n)

/* reduce */
// special case of foldLeft, starting at index 0
// output type can be different from input type
arr.reduce((m: Int, n: Int) => m + n)

def addHyphens(m: Any, n: Any) = {
  m.toString() + "-" + n.toString()
}

arr.reduce(addHyphens)

/* flatten */
// collapses one level of nested structures
List(List(1, 2), List(3, 4)).flatten


/* flatMap */
// frequently used
// combines mapping and flattening
val nestedList = List(List(1, 2), List(3, 4), List(5, 6))
nestedList.flatMap((x: List[Int]) => x.map(_ * 2))
nestedList.flatMap(x => x.map(_ * 2))


// all these constructs work on maps too
val nums = Map(1 -> "one", 2 -> "two", 3 -> "three", 4 -> "four")
nums.map((x: (Int, String)) => x._2 + " chickens")
nums.map(x => x._2 + " chickens")