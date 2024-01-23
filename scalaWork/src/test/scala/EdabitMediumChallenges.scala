import org.scalatest._
import org.scalatest.flatspec.AnyFlatSpec
import scalaSolutions.EdabitMediumChallenges._


class EdabitMediumChallengesTest extends AnyFlatSpec {

  "Count Booleans" should "be correct" in {
    assert(countTrue(List(true, false, false, true, false)) == 2)
    assert(countTrue(List(false, false, false, false)) == 0)
    assert(countTrue(List()) == 0)
    assert(countTrue(List(false, false, true, true, false, false, false, true, true, true, true, false, true, true, false)) == 8)
    assert(countTrue(List(true, false, true, true, false, false, false, false, false)) == 3)
    assert(countTrue(List(false, true, true, false, true, true, false, true, false, true, false, true, false, true, false)) == 8)
    assert(countTrue(List(true, false, true, true, true, false, true, true, false, false)) == 6)
    assert(countTrue(List(false, false, false, false, true, false, true, false, true, false, false)) == 3)
    assert(countTrue(List(true, false, false, false, true, false, false, true, false, false, false)) == 3)
    assert(countTrue(List(true, true, false, true, false, false, false, false, true, false)) == 4)
    assert(countTrue(List(true, false, true, true, false, true, true, true, true, false, true, false, true, false)) == 9)
    assert(countTrue(List(true, false, true, true, true, true, false, true, true, false, true, false, false, false, false)) == 8)
    assert(countTrue(List(true, true, false, false, false, false, true, false, true, true, false, true)) == 6)
  }

  "Redundant method" should "return a function which returns the string it was passed as a parameter" in {
    val apple = "apple"
    val pear = "pear"
    val empty = ""

    val f1 = redundant(apple)
    val f2 = redundant(pear)
    val f3 = redundant(empty)

    assert(f1.apply() == apple)
    assert(f2.apply() == pear)
    assert(f3.apply() == empty)
  }

  "emptyRegEx" should "return true only for empty strings" in {
    assert(regExEmptyString(""))
    assert(!regExEmptyString(" "))
    assert(!regExEmptyString("\n"))
    assert(!regExEmptyString("hello"))
  }

  "arrayOfMultiples" should "return a list of multiples based on the parameters" in {
    assert(arrayOfMultiples(7, 5) == List(7, 14, 21, 28, 35))
    assert(arrayOfMultiples(2, 1) == List(2))
    assert(arrayOfMultiples(2, 0) == List())
  }

  "warOfNumbers" should "return the difference between the sum of all odds and the sum of all even numbers in provided list" in {
    assert(warOfNumbers(List(5,9,45,6,2,7,34,8,6,90,5,243)) == 168)
    assert(warOfNumbers(List(654,7,23,3,78,4,56,34)) == 793)
    assert(warOfNumbers(List(1,2,3,4,5,6,7,8,9)) == 5)
    assert(warOfNumbers(List(97,83,209,141,134,298,110,207,229,275,115,64,244,278)) == 228)
    assert(warOfNumbers(List(332,92,35,315,109,168,320,230,63,323,16,204,105,17,226,157,245,44,223,136,93)) == 83)
    assert(warOfNumbers(List(322,89,36,310,297,157,251,55,264,244,200,304,25,308,311,269,303,257,6,311,307,310,50,46,54,237,59,105,267)) == 846)
    assert(warOfNumbers(List(50,100,149,1,200,199,3,2)) == 0)
  }

  "squarePatch" should "return a List of Lists of Integers that contains n Lists of n Integers that are all n, where n is the given parameter" in {
    assert(squarePatch(2) == List(List(2, 2), List(2, 2)))
    assert(squarePatch(3) == List(List(3, 3, 3), List(3, 3, 3), List(3, 3, 3)))
    assert(squarePatch(1) == List(List(1)))
    assert(squarePatch(0) == List())
  }

  "recursiveSum" should "recursively return the sum of the passed in list" in {
    assert(recursiveSum(List(1, 2, 3, 4)) == 10)
    assert(recursiveSum(List(-1, -1, -1)) == -3)
    assert(recursiveSum(List(1)) == 1)
    assert(recursiveSum(List()) == 0)
  }

  "letterCount" should "return the number of times a char appears in a List[List[Char]]" in {
    assert(letterCount(
      List(
        List('D', 'E', 'Y', 'H', 'A', 'D'),
        List('C', 'B', 'Z', 'Y', 'J', 'K'),
        List('D', 'B', 'C', 'A', 'M', 'N')
      )
    , 'D') == 3)

    assert(letterCount(
      List(
        List('D', 'E', 'Y', 'H', 'A', 'D'),
        List('C', 'B', 'Z', 'Y', 'J', 'K')
      )
      , 'Z') == 1)
  }

}