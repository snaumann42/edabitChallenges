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

  "FrequencyDistribution method" should "return a frequency count of each value in the order found in the passed in parameter" in {
    assert(Vector((3, 2), (2, 1), (4, 3)) == FrequencyDistribution(Vector(3, 2, 3, 4, 4, 4)))
    assert(Vector((3, 2), (4, 3), (2, 1)) != FrequencyDistribution(Vector(3, 2, 3, 4, 4, 4)))
    assert(Vector(("hello", 3), ("bye", 2)) == FrequencyDistribution(Vector("hello", "bye", "hello", "hello", "bye")))
    assert(Vector((2.2, 3), (4.4, 2)) == FrequencyDistribution(Vector(2.2, 4.4, 2.2, 2.2, 4.4)))
  }

  "ReverseOddLengthWords method" should "reverse all odd words in the string parameter" in {
    assert(ReverseOddLengthWords("One two three four") == "enO owt eerht four")
    assert(ReverseOddLengthWords("Make sure uoy only esrever sdrow of ddo length")
      == "Make sure you only reverse words of odd length")
  }

  "CountLayers method" should "return the layer of rugs passed in" in {
    assert(0 == CountLayers(List()))
    assert(2 == CountLayers(List("AAA", "ABA", "AAA")))
    assert(1 == CountLayers(List("AA", "AA")))
    assert(5 == CountLayers(
      List("AAAAAAAAA",
           "ABBBBBBBA",
           "ABCCCCCBA",
           "ABCDDDCBA",
           "ABCDEDCBA",
           "ABCDDDCBA",
           "ABCCCCCBA",
           "ABBBBBBBA",
           "AAAAAAAAA")))
  }

  "BinaryTreeSum method" should "return the Left if the left tree sum is larger, Right if the right one is and empty string if there are no nodes or they are equal" in {
    assert("" == BinaryTreeSum(Array()))
    assert("" == BinaryTreeSum(Array(3)))
    assert("Left" == BinaryTreeSum(Array(3, 10)))
    assert("Right" == BinaryTreeSum(Array(3, 2, 10)))
    assert("Right" == BinaryTreeSum(Array(1, 4, 100, 5)))
    assert("Right" == BinaryTreeSum(Array(3, 2, 10, 6, 3, -1, -1)))
    assert("Left" == BinaryTreeSum(Array(3, 10, 2, -1, -1, 6, 3)))
    assert("Right" == BinaryTreeSum(Array(3, 10,2, -1,-1,6,3, 4,5,3,7,8,9,2,2)))
  }

  "ParenthesesCluster method" should "return balanced clusters of parentheses" in {
    assert(List("()", "()", "()") == ParenthesesCluster("()()()"))
    assert(List("((()))") == ParenthesesCluster("((()))"))
    assert(List("((()))", "(())", "()", "()", "(()())") == ParenthesesCluster("((()))(())()()(()())"))
    assert(List("((())())", "(()(()()))") == ParenthesesCluster("((())())(()(()()))"))
  }

  "Encrypt method" should "return a list of Ints" in {
    assert(List(72, 29, 7, 0, 3) == encryptLetterValues("Hello"))
    assert(List(72, 33, -73, 84, -12, -3, 13, -13, -68) == encryptLetterValues("Hi there!"))
  }

  "Decrypt method" should "return a list of Ints" in {
    assert(decryptLetterValues(List(72, 29, 7, 0, 3)) == "Hello")
    assert(decryptLetterValues(List(72, 33, -73, 84, -12, -3, 13, -13, -68)) == "Hi there!")
  }
  
  "allPremutations method" should "return a list of all purmutations of a string" in {
    assert(1 == allPremutations("a").length)
    assert(2 == allPremutations("ab").length)
    assert(6 == allPremutations("abc").length)
  }
}