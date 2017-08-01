// A good discussion of when and how to use infix notation:
// http://docs.scala-lang.org/style/method-invocation.html

// We'll use the simple example of vectors in a cartesian coordinate system

case class Vector(x: Int, y: Int) {
  def add(p: Vector): Vector = Vector(x + p.x, y + p.y)
  def +(p: Vector): Vector = this.add(p)

  override def toString: String = "(%s, %s)".format(x, y)
}

val p0 = Vector(5, 5)
val p1 = Vector(1, 2)

// The below statements will all return Vector(6, 7)
p0.add(p1)
p0 add p1  // infix notation is a bit strange here

p0.+(p1)  // regular method call notation is very strange here
p0 + p1
