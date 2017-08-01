// Constructor parameters are accessible in the class
class PointA(x: Int, y: Int) {

  def printCoordinates() = println("The point is: (%s, %s)".format(x, y))

  def mirror(axis: Char) = {
    require(axis == 'x' || axis == 'y', "Must mirror across x or y axis.")
    axis match {
      case 'x' => new PointA(x, -y)
      case 'y' => new PointA(-x, y)
    }
  }

  override def toString: String = "(%s, %s)".format(x, y)
}

val point1 = new PointA(1, 2)
point1.printCoordinates()  // prints "The point is: (1, 2)"
point1.mirror(axis='x')  // returns PointA(1, -2)
point.x  // doesn't work - there is no accessor for x


// Putting a val before a parameter generates an accessor
class PointB(val x: Int, val y: Int) extends PointA(x, y)

val point2 = new PointB(1, 2)
point2.x  // returns 1


// Putting a var before a parameter generates an accessor and mutator
// Pay attention to the scoping in this example
class PointC(var a: Int, var b: Int) extends PointB(a, b) {
  override def printCoordinates(): Unit = println("The point is: (%s, %s)".format(a, b))
}

val point3 = new PointC(1, 2)
point3.a  // returns 1
point3.a = 999
point3.a  // returns 999
point3.x  // returns 1, since we inherited from PointB

point3.printCoordinates()  // prints "The point is: (999, 2)"
                           // if we hadn't overridden the method from the superclass,
                           // it would have used PointB.printCoordinates and printed "The point is: (1, 2)"
