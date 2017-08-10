/* Pairs */

val pair = ("one", 1)  // (String, Int) = ("one", 1)

// Decomposition
var label0 = pair._1  // "one"
var value0 = pair._2  // 1

val (label1, value1) = pair  // same as above. generally preferred over ._1

// Pattern matching on pairs
val pair1 = (1, 2)
pair1 match {
  case x => "x: %s".format(x)
  case (x, y) => "x: %s, y: %s".format(x, y)
  case _ => "wildcard"
}

