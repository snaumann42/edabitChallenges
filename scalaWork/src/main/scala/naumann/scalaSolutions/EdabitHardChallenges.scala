package naumann.scalaSolutions

import scala.util.matching.Regex
import java.time.temporal.ChronoUnit
import java.time.LocalDate
import scala.collection.mutable
import scala.math.BigDecimal

object EdabitHardChallenges {

  // Regex validate pin, allow for only 4 or 6 characters and only numeric, no whitespace
  val pinRegEx: Regex = """\d{4}|\d{6}""".r
  def PinValidation(pin: String): Boolean = {
    pinRegEx.matches(pin)
  }

  val evenish = "Evenish"
  val oddish = "Oddish"

  // Return if the number parameter is oddish or evenish, a number is oddish
  // if all of it's digits add up to an odd number and evenish if it's digits
  // add up to an even number.
  def OddishEvenish(value: Int): String = {
    val digitSum = value.toString.map(_.asDigit).sum
    if (digitSum % 2 == 0) {
      evenish
    } else {
      oddish
    }
  }

  // Calculate how many days there are inbetween two dates
  def DaysBetween(startDate: LocalDate, endDate: LocalDate): Long = {
    ChronoUnit.DAYS.between(startDate, endDate)
  }

  case class Grocery(product: String, quantity: Int, price: Double)
  // Calculate the total cost of groceries
  def CalculateBill(groceries: List[Grocery]): Double = {
    val totalPrice = groceries.map{
      (grocery: Grocery) =>
        grocery.quantity * grocery.price
    }.sum
    BigDecimal(totalPrice).setScale(2,BigDecimal.RoundingMode.HALF_UP).toDouble
  }

  case class SortableTuple[A](index: Int, value: Option[A], counter: Int) extends Ordered[SortableTuple[A]] {
    import scala.math.Ordered.orderingToOrdered

    def compare(that: SortableTuple[A]): Int = this.index compare that.index
  }

  // Calculate the frequencies of the given type and
  // the returned object should contain them in the order received
  def FrequencyDistribution[A](values: Vector[A]): Vector[(A, Int)] = {
    var map: Map[A, SortableTuple[A]] = Map()
    var index = 1
    values.foreach{
      value =>
        // Keep a tuple of index and counter
        val sortable = map.getOrElse(value, SortableTuple(0, None, 0))
        if(sortable.index == 0){
          map = map + (value -> SortableTuple(index, Some(value), 1))
          index += 1
        } else {
          map = map + (value -> SortableTuple(sortable.index, sortable.value, sortable.counter+1))
        }
    }

    // Sort based on the "index" saved when value is added to the map, then update to a tuple of (value, count)
    map.values.toVector.sorted.map{ value => (value.value.get, value.counter)}
  }

  // This method will return a string with all odd length words reversed in the string
  def ReverseOddLengthWords(value: String): String = {
    value.split(' ').map{
      (word: String) =>
        if (word.length % 2 == 0) {
          word
        } else {
          word.reverse
        }
    }.mkString(" ")
  }

  // This method counts the layers of "rugs" passed in. The parameter is an array of Strings, ABBA would be 2 layers, AABCBAA would be 3, etc
  def CountLayers(value: List[String]): Int = {
    var largestLayerCount = 0
    value.map{layer =>
      var currentRug: Char = ' '
      var currentCount: Int = 0
      layer.map{
        char =>
          if (char != currentRug){
            currentRug = char
            currentCount += 1
          }
      }
      // See if our current string loop found more rug layers
      val layers = (currentCount/2) + 1
      if (largestLayerCount < layers){
        largestLayerCount = layers
      }
    }
    largestLayerCount
  }

  val Left = "Left"
  val Right = "Right"
  val Neither = ""

  def BinaryTreeSum(arr: Array[Long]): String = {
    var sumLeft = 0L
    var sumRight = 0L
    var min = 1
    var max = 2

    while (min < arr.length) {
      val pivot = max/2 + 1

      sumLeft += arr.slice(min, pivot).map{(num: Long) =>
          if(num != -1) num else 0
      }.sum
      sumRight += arr.slice(pivot, max+1).map{(num: Long) =>
        if(num != -1) num else 0
      }.sum

      min += max
      max *= 2
    }

    (sumLeft, sumRight) match {
      case (0, 0) => Neither
      case _ if (sumLeft == sumRight) => Neither
      case _ if (sumLeft > sumRight) => Left
      case _ if (sumLeft < sumRight) => Right
    }
  }

  // This method takes a string of parentheses and returns clusters of balanced parentheses in a list
  def ParenthesesCluster(items: String): List[String] = {
    var currentString = ""
    var clusterList: List[String] = List()
    var openCount = 0

    items.foreach{ item =>
      currentString += item
      if (item == '('){
        openCount += 1
      } else {
        openCount -= 1
      }

      if (openCount == 0){
        clusterList = clusterList :+ currentString
        currentString = ""
      }
    }
    clusterList
  }

  // This method "encrypts" a string, using the value of the first letter, then
  // for every additional letter, the difference between it's value and the
  // last chars value
  def encryptLetterValues(message: String): List[Int] = {
    var encodedMessage: List[Int] = List(message.head.toInt)
    var lastChar = message.head
    message.tail.foreach{ char =>
      encodedMessage = encodedMessage :+ char.toInt - lastChar.toInt
      lastChar = char
    }
    encodedMessage
  }

  // This method reverses the encryptLetterValues logic to produce a message again
  def decryptLetterValues(encodedMessage: List[Int]): String = {
    var message: String = "" + encodedMessage.head.toChar
    encodedMessage.tail.foreach{ num =>
      message += (message.last.toInt +  num).toChar
    }
    message
  }

  def allPremutations(item: String): Vector[String] = {
    var results = Vector[String]()

    if (item.length == 0){
    } else if(item.length == 1){
      results = results :+ item
    } else {
      item.zip(0 until item.length).foreach { (tuple: (Char, Int)) =>
        val currentChar = tuple._1
        val remainingChars = item.slice(0, tuple._2).concat(item.slice(tuple._2+1, item.length+1))
        
        allPremutations(remainingChars).map{(result: String) =>
          results = results :+ currentChar + result
        }
      }
    }
    
    results
  }
  
}
