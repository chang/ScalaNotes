/* Syntax review */

// Types: SimpleType or FunctionType
val a: Boolean = true
val b: String = "this is a string"
val c: Int => String = (x: Int) => x.toString() + " dollars"
c(3)

// Call by name vs. call by value
// adding => makes a parameter call by name
def add(x: Int, y: => Int) = {
  x + y
}

/* Functions as Data */

// this.object for self references
// require() for enforcing requirements
// assert() for checking code

class Fraction(x: Int, y: Int) {
  require(y != 0, "Denominator must be nonzero")  // why require and not throw exception?
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  val a = x / gcd(x, y)
  val b = y / gcd(x, y)
  assert(gcd(a, b) == 1)

  // like __str__
  override def toString: String = "%s/%s\n".format(a, b)

  def add(frac: Fraction): Fraction = {
    val num = a * frac.b + b * frac.a
    val denom = b * frac.b
    new Fraction(num, denom)
  }

  def neg: Fraction = new Fraction(-a, b)

  def subtract(frac: Fraction) = this.add(frac.neg)

  def lessThan(frac: Fraction): Boolean = a * frac.b < frac.a * b

  def maximum(frac: Fraction): Fraction = if (this.lessThan(frac)) frac else this

  // Using custom operators
  def + (frac: Fraction): Fraction = this.add(frac)
  def - (frac: Fraction): Fraction = this.subtract(frac)
  def unary_- : Fraction = this.neg
}

val x1 = new Fraction(2, 3)
x1.neg
x1.subtract(new Fraction(1, 3))
x1.maximum(new Fraction(1, 3))

// Infix notation: We an write "r.add(s)" as "r add s"
new Fraction(1, 2) add new Fraction(2, 3)
new Fraction(1, 2) subtract new Fraction(1, 3)
new Fraction(5, 4) - new Fraction(1, 4)