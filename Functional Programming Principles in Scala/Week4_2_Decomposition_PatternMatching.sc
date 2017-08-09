// For a motivating example of pattern matching, see: https://www.coursera.org/learn/progfun1/lecture/cdHAM/lecture-4-6-pattern-matching
case class Point(x: Int, y: Int) {
  override def toString() = "(%s, %s)".format(x, y)
}

case class Vector(x: Point, y: Point)

def printIt(x: Any): Unit = {
  x match {
    case Point(x, y) => println("It's a Point: (%s, %s)".format(x, y))
    case Vector(x, y) => println("It's a Vector: %s --> %s".format(x.toString, y.toString))
    case _ => println("Unknown type")
  }
}

val p0 = Point(2, 3)
val p1 = Point(6, 6)
printIt(p0)  // It's a Point: (2, 3)
printIt(Vector(p0, p1))  // It's a Vector: (2, 3) --> (6, 6)
printIt(true)  // Unknown type


/*  */
def typeAsString(x: Any): String = {
  val N = 16
  x match {
    case N => "My favorite number"  // constants must be capitalized, to distinguish them from
    case b: Boolean => "Boolean"
    case i: Integer => "Integer"
  }
}
typeAsString(true)
typeAsString(16)  // this evaluates to "My favorite number" since match expressions short circuit