/* Higher order functions */
// Express function input return type in parameter list as (function: Type => Type)

object Summation {
  def sum(x: Int): Int = {
    if (x == 0) 0 else x + sum(x - 1)
  }

  def sumWithFunction(x: Int, f: Int => Int): Int = {
    if (x == 0) 0 else f(x) + sumWithFunction(x - 1, f)
  }

  def sumSquares(x: Int) = sumWithFunction(x, (i: Int) => i * i)

  def sumDoubles(x: Int) = sumWithFunction(x, i => i * 2)  // note the type inference on the lambda
}


/* Anonymous functions */
val multiply = (x: Int, y: Int) => x * y
multiply(5, 10)


/* Linear vs tail recursion */
// Tail recursion doesn't need extra stack space. Also, in FP languages,
// there is typically tail recursion optimization

import scala.annotation.tailrec

def sumLinear(x: Int): Int = {
  if (x == 0) 0 else x + sumLinear(x - 1)
}

def sumTail(x: Int): Int = {
  @tailrec
  def loop(x: Int, acc: Int): Int = {
    if (x == 0) acc
    else loop(x - 1, acc + x)
  }
  loop(x, 0)
}

sumLinear(5)
sumTail(5)


/* Currying */

// Motivation:
// Here's a constructor function for calculating sums
// This is a function that takes a function as an param and returns another function
def sumConstructor(func: Int => Int): Int => Int = {
  def sum(x: Int): Int = {
    if (x == 0)
      0
    else
      func(x) + sum(x - 1)
  }
  sum
}

def sumDouble = sumConstructor(x => x * 2)
sumDouble(5)
def sumSquares = sumConstructor(x => x * x)
sumSquares(5)

// Can we avoid the middleman?
sumConstructor(x => x * 2)(5)

// The function is evaluated left to right, so:
// sumConstructor(x => x * 2) (5) is evaluated to:
// sumDouble(5) and finally:
// 30

// Now, instead of the wrapper we wrote, we'll use currying
def sumCurried(func: Int => Int)(x: Int): Int = {
  if (x == 0)
    0
  else
    func(x) + sumCurried(func)(x - 1)
}

// Now we can put in both arguments at once
sumCurried(x => x * 2)(5)

// Or use it as a constructor
var sumDouble2 = sumCurried(x => x * 2)(_)
sumDouble2(5)

// The type is: (Int => Int) => Int => Int
// Types are associative to the right: Int => Int => Int is the same as Int => (Int => Int)
sumCurried _


/* Exercises */
def product(func: Int => Int)(a: Int, b: Int): Int = {
  /* Multiplies the integers between a and b modified by a function */
  if (a > b) 1
  else b * product(func)(a, b - 1)
}

def factorial(n: Int) = product(i => i)(1, n)
factorial(5)

// Write a function that generalizes sum and product
def combineGeneral(modifyFunction: Int => Int, combineFunction: (Int, Int) => Int, terminal: Int)
                  (a: Int, b: Int): Int = {
  if (a > b) terminal
  else combineFunction(modifyFunction(b), combineGeneral(modifyFunction, combineFunction, terminal)(a, b - 1))
}

def factorial2(n: Int) = combineGeneral(modifyFunction = i => i, combineFunction = (x, y) => x * y, terminal = 1)(1, n)
factorial2(5)