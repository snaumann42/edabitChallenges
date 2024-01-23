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

  
}
