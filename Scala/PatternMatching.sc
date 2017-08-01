/* 3.7, 3.8, 3.13 from The Scala Cookbook */


// basic usage
// think about when it's better to use a Map
// in this case we don't need pattern matching
def positiveOrNegative(x: Int): String = {
  x match {
    case -1 => "negative"
    case 1 => "positive"
  }
}

positiveOrNegative(1)
//positiveOrNegative(100)  // will return a scala.MatchError exception, since this case isn't handled


// handling unknown cases with the _ wildcard
def positiveOrNegative2(x: Int): String = {
  x match {
    case -1 => "negative"
    case 1 => "positive"
    case _ => "unknown"  // _ is a wildcard, handles all "other" cases
    // case unknownInput => "Unexpected case: %s".format(unknownInput)
      // alternatively, can also store and return the unexpected value as shown above
  }
}

positiveOrNegative2(100)


// using predicates in a case
// an "if" expression in a case statement is known as a "guard"
def positiveOrNegative3(x: Int): String = {
  x match {
    case x if x < 0 => "negative"
    case x if x > 0 => "positive"
    case _ => "unknown"
  }
}

positiveOrNegative3(100)

/*
* From the Scala CookBook Recipe 3.7:
* Compiling your match expression to a tableswitch or lookupswitch is better for performance,
* because it results in a branch table rather than a decision tree.
* When a value is given to the expression, it can jump directly to the result
* rather than working through the decision tree.
* */

import scala.annotation.switch
val num = 1

@switch
var str = num match {
  case 0 => "zero"
  case 1 => "one"
}


// matching on data types
def classAsString(x: Any): String = {
  x match {
    case x: String => "string"
    case x: Int => "int"
    case x: Float => "float"
    case x: Double => "double"
    case x: Char => "character"
  }
}

classAsString(1.23)
classAsString('1')


// unpacking tuples
def tupleAsString(tup: Any): String = {
  tup match {
    case (x: String, y: String) => "A 2 element tuple of strings: (%s, %s)".format(x, y)
    case (x, y) => "A 2 element tuple: (%s, %s)".format(x, y)
    case (x, y, z) => "A 3 element tuple: (%s, %s, %s)".format(x, y, z)
    case _ => "Unknown tuple format"
  }
}

tupleAsString(Tuple2(3, 1.11))
tupleAsString(Tuple3(1, 2, 3))
tupleAsString(Tuple2("cat", "dog"))  // case statements short circuit, so if case(x, y) was put
                                     // before case(x: String, y: String), this result would be different