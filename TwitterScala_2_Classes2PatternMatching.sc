/* https://twitter.github.io/scala_school/basics2.html */

/* The apply() method */
// Becomes a constructor - good for classes that do one thing.

// apply() as a constructor
case class Point(x: Int, y: Int)

object OriginMaker {
  def apply() = {
    new Point(0, 0)
  }
}

// calling a class as a method?
val x = OriginMaker()

class FooBar {
  def apply() = 10
}

val fb = new FooBar
fb()


/* Objects: A single instance of a class. Often used for factories. */
// classes and objects can have the same name
// the object is called a 'companion object', used often for Factories

object RectangularPrism {
  val length = 3
  val width = 10
  val height = 5

  def getVolume(): Int = {
    length * width * height
  }
}

RectangularPrism.getVolume()


/* Pattern Matching */
// Check a value against a pattern
// "Can deconstruct a value into its constituent parts?
// use in place of if/else

val x2 = 100

x2 match {
  case 1 => "one"
  case 100 => "one hundred"
}

// As a function
def matchNumber(x: Int): String = {
  x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "other"
  }
}

matchNumber(1)
matchNumber(2)
matchNumber(50)

// More advanced pattern matching with objects
def getQuadrant(point: Point): String = {
  point match {
    case Point(0, 0) => "Origin"
    case Point (_, _ > 1) => "test"
    case _ => "Other"
  }
}

getQuadrant(Point(0, 0))
getQuadrant(Point(0, 1))
getQuadrant(Point(0, 2))


/* Functions are Objects */
/*
The syntactic sugar of apply helps unify the duality of object and functional programming.

You can pass classes around and use them as functions and
  functions are just instances of classes under the covers.

Does this mean that every time you define a method in your class,
  you’re actually getting an instance of Function*?

No, methods in classes are methods.
Methods defined standalone in the repl are Function* instances.
*/

/* Packages
package myPackageName will declare this file inside of package
to import:
import myPackageName.TwitterScala_2
*/

