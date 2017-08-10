// An example of currying a function using another function
def booleanList[T](xs: List[T], x: T)(compareFunction: (T, T) => Boolean) = {
  xs.map(i => compareFunction(i, x))
}

// Applying both parameter lists at once
val l0 = List(1, 2, 3, 4)
val equalsList = booleanList(l0, 3)((x, y) => x == y)  // List(false, false, true, false)

// Creating a new function using the curried function
def equalsListFunction[T](xs: List[T], x: T) = booleanList(xs, x)((x, y) => x == y)
equalsListFunction(List(10, 11, 12), 11)  // List(false, true, false)