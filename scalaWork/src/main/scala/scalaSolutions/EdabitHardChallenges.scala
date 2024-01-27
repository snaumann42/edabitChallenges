package scalaSolutions

import scala.util.matching.Regex
import java.time.temporal.ChronoUnit
import java.time.LocalDate
import scala.math.BigDecimal

object EdabitHardChallenges {

  // Regex validate pin, allow for only 4 or 6 characters and only numeric, no whitespace
  val pinRegEx: Regex = """\d{4}|\d{6}""".r // bad scope
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
    if (digitSum % 2 == 0)
    {
      evenish
    }else{
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
    val totalPrice = groceries.map{grocery: Grocery => grocery.quantity * grocery.price}.sum
    BigDecimal(totalPrice).setScale(2,BigDecimal.RoundingMode.HALF_UP).toDouble
  }

  case class SortableTuple[A](index: Int, value: Option[A], counter: Int) extends Ordered[SortableTuple[A]] {
    import scala.math.Ordered.orderingToOrdered

    def compare(that: SortableTuple[A]): Int = this.index compare that.index
  }
  
  // Calculate the frequencies of the given type and
  // the returned object should contain them in the order recieved
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
      word: String =>
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
}
