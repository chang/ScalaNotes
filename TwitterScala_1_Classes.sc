/*
https://twitter.github.io/scala_school/basics.html
 */

/* FUNCTIONS
partial evaluation
currying
variable length
*/

def mult(x: Int, y: Int): Int = x * y

def multCurried(x: Int)(y: Int) = x * y

val mult3PartialEval = mult(_: Int, 3)

val mult3Curry = multCurried(3) _

val mult3Lambda = (x: Int) => x * 3

mult3PartialEval(4)
mult3Curry(3)
mult3Lambda(10)

// variable length
def addOneToAll(nums: Int*): Seq[Int] = {
  nums.map(x => x + 1)
}

addOneToAll(1, 2, 3)

/* CLASSES
class definition
inheritance
abstract classes
*/

// basic class definition with fields and a method
class TreeNode(x: Int) {
  val value = x
  var left: Any = 0
  var right: Any = 'a'

  def print() = {
    printf("Value: %s, Left: %s, Right: %s\n", value, left, right)
  }
}

val node = new TreeNode(3)
node.print()
node.right = 30
node.print()


// inheritance
class TreeNodeMult(x: Int, mult: Int = 1) extends TreeNode(x) {
  val multiplier = mult

  def multiply(): Int = value * multiplier

  override def print() = {
    printf("Value: %s, Left: %s, Right: %s, Multiplier: %s\n",
            value, left, right, multiplier)
  }
}

val node2 = new TreeNodeMult(x = 10, mult = 2)
node2.multiply()
node2.print()


// abstract class: a class that defines some methods but doesn't implement
//                 can't instantiate, this is used to construct concrete methods
abstract class Shape {
  def getArea(): Int

  def sayHello() = println("Hello world!")
}

class Rectangle(length: Int, width: Int) extends Shape {
  def getArea(): Int = length * width
}

val rect = new Rectangle(10, 20)
rect.getArea()


// a case class: special class good for storing immutable data
//               all constructor args accessible as public vals
case class Point(x: Int, y: Int)
val point = new Point(1, 2)


/* TRAITS
A collection of attributes and methods.
Use to inherit from (extend) or mix in (with) to classes.
Cannot instantiate, as it is an abstract class.

Trait vs abstract class?
 */

trait MoneyHolder {
  var amount = 0

  def add(money: Int) = {
    amount += money
  }
}

// example of inheriting from a trait
class TalkingWallet extends MoneyHolder {
  def talk() = {
    printf("You have $%s in your wallet\n", amount)
  }
}

val wallet = new TalkingWallet()
wallet.add(10); wallet.add(7)
wallet.talk()

// example of mixing with a trait
class Account(name: String) {
  val accountName = name
}

class BankAccount(name: String) extends Account(name) with MoneyHolder {
  def checkBalance() = {
    printf("You have $%s in your account.\n", amount)
  }
}
val acc = new BankAccount(name = "Eric")
acc.add(6950); acc.add(10000);
acc.checkBalance()


/* What the heck does this do?

trait Cache[K, V] {
  def get(key: K): V
  def put(key: K, value: V)
  def delete(key: K)
}

def remove[K](key: K)
 */


/* RECURSION */
def isSameClass(x: Any, y: Any): Boolean = {
  if (x.getClass() == y.getClass()) {
    true
  } else {
    false
  }
}

isSameClass(1, 2)
isSameClass(1.9, 2)
isSameClass(1.9, "foo")

def allSameClass(objects: Array[Any]): Boolean = {
  if (objects.length == 1) {
    true
  } else if (objects(0).getClass != objects(1).getClass()) {
    false
  } else {
    allSameClass(objects.tail)
  }
}

allSameClass(Array(1, 2, 3, 4, 5))
allSameClass(Array(1, 2, 3, 'a', 5))
