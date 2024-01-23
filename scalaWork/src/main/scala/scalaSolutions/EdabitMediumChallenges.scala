package scalaSolutions

import scala.util.matching.Regex

object EdabitMediumChallenges {

  // Create a function that accepts a list of booleans and returns a count for how many are true
  def countTrue(booleanList: List[Boolean]): Int = {
    booleanList.map{bool: Boolean =>
    if (bool)
      1
    else
      0
    }.sum
  }

  // Create a function that accepts a string and returns a function that returns that string
  def redundant(value: String): ()=>String = {
    () => value
  }

  // Create a RegEx to check for an empty string
  // Compile regex outside of method call since regex compilation is expensive
  val emptyRegEx: Regex = """^$""".r // bad scope
  def regExEmptyString(value: String): Boolean = emptyRegEx.matches(value)

  // Create a function that takes two numbers as arguments (num, length) and
  // returns an array of multiples of num until the list length reaches length.
  def arrayOfMultiples(num: Int, len: Int): List[Int] = {
    (1 to len).map {value =>
      num * value
    }.toList
  }

  // Given a list of positive numbers, sum up the Odds and Even numbers separately and
  // return the difference (larger sum - smaller sum)
  def warOfNumbers(numbers: List[Int]): Int = {
    // Sum even numbers
    val evenSum = numbers.map{ num =>
      if (num % 2 == 0)
        num
      else
        0
    }.sum

    // Sum odd numbers
    val oldSum = numbers.map { num =>
      if (num % 2 != 0)
        num
      else
        0
    }.sum

    math.abs(oldSum - evenSum)
  }

  // Create a function that takes a 0 or positive integer and outputs an n x n squar consisting of only integer n
  def squarePatch(value: Int):List[List[Int]] = {
    val internalList: List[Int] = (1 to value).map{num: Int => value}.toList
    (1 to value).map{num:Int => internalList}.toList
  }

  // Create a function that finds the sum of an List recursively
  def recursiveSum(values: List[Int]): Int = {
    values.length match {
      case 0 => 0
      case 1 => values.head
      case _ => values.head + recursiveSum(values.tail)
    }
  }

  // Create a function that counts the number of times a character appears in a List[List[Char]]
  def letterCount(charLists: List[List[Char]], searchChar: Char): Int = {
    charLists.flatten.map{char: Char =>
      if (char == searchChar)
        1
      else
        0
    }.sum
  }
  
}
