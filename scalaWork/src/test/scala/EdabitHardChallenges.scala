import org.scalatest._
import org.scalatest.flatspec.AnyFlatSpec
import scalaSolutions.EdabitHardChallenges._
import java.time.LocalDate


class EdabitHardChallengesTest extends AnyFlatSpec {

  "Pin validation method" should "return a boolean if the parameter is 4 or 6 digits without whitespace" in {
    assert(PinValidation("1234"))
    assert(PinValidation("123456"))
    assert(!PinValidation("12 4"))
    assert(!PinValidation(""))
    assert(!PinValidation("123456789"))
  }

  "oddish evenish method" should "return 'Oddish' or 'Evenish' based on the provided parameter" in {
    assert(OddishEvenish(11) == evenish)
    assert(OddishEvenish(111) == oddish)
    assert(OddishEvenish(1111) == evenish)
    assert(OddishEvenish(11111) == oddish)
  }

  "Days in between method" should "return a count of days in between two given dates" in {
    assert(DaysBetween(LocalDate.parse("2023-01-02"), LocalDate.parse("2023-01-01")) == -1)
    assert(DaysBetween(LocalDate.parse("2023-01-01"), LocalDate.parse("2023-01-01")) == 0)
    assert(DaysBetween(LocalDate.parse("2023-01-01"), LocalDate.parse("2023-01-02")) == 1)
    assert(DaysBetween(LocalDate.parse("2023-01-01"), LocalDate.parse("2023-01-03")) == 2)
  }

  "CalculateBill method" should "return the total for the list of groceries given as a parameter" in {
    assert(19.45 == CalculateBill(List(Grocery("milk", 1, 1.50), Grocery("butter", 4, 2.99), Grocery("beans", 1, 5.99))))
    assert(3.00 == CalculateBill(List(Grocery("milk", 2, 1.50))))
    assert(0.0 == CalculateBill(List()))
  }
}