/* */


/* Pattern Matching continued */

case class Point(x: Int, y: Int) {
  def print(): Unit = {
    printf("x: %s, y: %s", x, y)
  }
}

// This works, but the conditions make it verbose
def findQuadrantBad(point: Point): String = {
  point match {
    case _ if point.x == 0 && point.y == 0 => "Origin"
    case _ if point.x > 0 && point.y > 0 => "Quadrant 1"
    case _ if point.x < 0 && point.y < 0 => "Quadrant 3"
    case _ => "Other"
  }
}

findQuadrantBad(Point(0, 0))
findQuadrantBad(Point(10, 15))
findQuadrantBad(Point(-10, 15))

// Case classes are designed to be pattern matched
def findQuadrantBetter(point: Point) = {
  point match {
    case Point(0, 0) => "Origin"
    case _ => "Other"
  }
}

findQuadrantBetter(Point(1, 1))


/* Exception */
import java.io.FileReader

def initFileReader(file: String) = {
  try {
    val reader = new FileReader(file)
    printf("Successfully opened '%s'\n", file)
    reader
  } catch {
    case e: java.io.FileNotFoundException => {
      printf("Yep, '%s' doesn't exist!\n", file)
    }
  }
}

val r1 = initFileReader("nonexistent_file.txt")
val r2 = initFileReader("/Users/eric/.bashrc")