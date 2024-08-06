import naumann.Util
import naumann.playground.SortingAlgorithms
import org.scalatest.flatspec.AsyncFlatSpec

import scala.concurrent.Future
import scala.util.Random

class AsyncSortingAlgorithmTests extends AsyncFlatSpec{

  case class Result(duration: Long, description: String)

  "Comparative testing" should "with a random list, quick sort should be the fastest" in {
    val testArray = Array.fill(100000)(Random.nextInt(200000))

    val results: List[Future[Result]] = List(
      Future(Result(Util.timing(
        SortingAlgorithms.bubbleSort(testArray.clone()))
       , "bubble")),
      Future (Result(Util.timing(
        SortingAlgorithms.quickSortOptimized(testArray.clone()))
        , "quick")),
      Future (Result(Util.timing(
        SortingAlgorithms.insertionSort(testArray.clone()))
        , "insert")),
      Future (Result(Util.timing(
        SortingAlgorithms.selectionSort(testArray.clone()))
        , "selection"))
    )

    val futureList = Future.sequence(results)

    futureList.map{
      results =>
        results.foreach(result => println(s"${result.description} completed in ${result.duration/ 1e9d} seconds"))
        val minResult: Result = results.minBy(f => f.duration)
        assert(minResult.description == "quick")
    }
  }

  "Comparative testing" should "with a presorted list, selection sort should be the fastest" in {
    val testArray = Range(0, 100000).toArray

    val results: List[Future[Result]] = List(
      Future(Result(Util.timing(
        SortingAlgorithms.bubbleSort(testArray.clone()))
        , "bubble")),
      Future (Result(Util.timing(
        SortingAlgorithms.insertionSort(testArray.clone()))
        , "insert")),
      Future (Result(Util.timing(
        SortingAlgorithms.selectionSort(testArray.clone()))
        , "selection")),
      Future (Result(Util.timing(
        SortingAlgorithms.quickSortOptimized(testArray.clone()))
        , "quick"))
    )

    val futureList = Future.sequence(results)

    futureList.map{
      results: Seq[Result] =>
        results.foreach(result => println(s"${result.description} completed in ${result.duration/ 1e9d} seconds"))
        val minResult: Result = results.minBy(f => f.duration)
        assert(minResult.description == "selection")
    }
  }
}
