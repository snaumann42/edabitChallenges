package test.scala

import naumann.Util
import naumann.playground.SortingAlgorithms
import org.scalatest.flatspec.AnyFlatSpec


class SortingAlgorithmTests extends AnyFlatSpec {

  "Bubble sort" should "sort an array" in {
      val testCollection = Array(5, 4, 3, 2, 1)
      val result = SortingAlgorithms.bubbleSort(testCollection)
      assert(Util.compare(result, Array(1, 2, 3, 4, 5)))
  }

  "Insertion sort" should "sort an array" in {
      val testCollection = Array(5, 4, 3, 2, 1)
      val result = SortingAlgorithms.insertionSort(testCollection)
      assert(Util.compare(result, Array(1, 2, 3, 4, 5)))
  }

  "Section sort" should "sort an array" in {
      val testCollection = Array(5, 4, 3, 2, 1)
      val result = SortingAlgorithms.selectionSort(testCollection)
      assert(Util.compare(result, Array(1, 2, 3, 4, 5)))
  }

  "Quick sort" should "sort an array" in {
      val testCollection = Array(5, 4, 1, 2, 3)
      val result = SortingAlgorithms.quickSortOptimized(testCollection)
      assert(Util.compare(result, Array(1, 2, 3, 4, 5)))
  }


}
