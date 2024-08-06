package naumann.playground

import scala.math.Ordered.orderingToOrdered

object SortingAlgorithms {

  private def swap[T: Ordering](array: Array[T], index1: Int, index2: Int): Unit = {
    val temp = array(index1)
    array(index1) = array(index2)
    array(index2) = temp
  }

  // Sorting
  def bubbleSort[T: Ordering] (array: Array[T]): Array[T] = {
    Range(0, array.length-1).foreach{ index1 =>
      Range(0, array.length - index1 - 1).foreach{ lowerBound =>
        val upperBound = lowerBound+1
        if(array(lowerBound) > array(upperBound)){
          swap(array, upperBound, lowerBound)
        }
      }
    }
    array
  }

  def insertionSort[T: Ordering] (array: Array[T]): Array[T] = {
    Range(0, array.length).foreach{outer =>
      val key = array(outer)
      Range.inclusive(outer-1, 0, -1).foreach{inner =>
        if(array(inner) > key){
          array(inner + 1) = array(inner)
          array(inner) = key
        }
      }
    }
    array
  }

  def selectionSort(array: Array[Int]): Array[Int] = {
    Range(0, array.length).foreach{outer =>
      var minIndex = outer
      Range(outer + 1, array.length).foreach{inner =>
        if(array(inner) < array(minIndex)){
          minIndex = inner
        }
      }
      // swap values if needed
      if(minIndex != outer){
        swap(array, minIndex, outer)
      }
    }
    array
  }

  // Select a pivot point, then recursively sort the left (less than pivot) and right (greater than pivot)
  // Causes stack overflow error around 9K items in a sorted list (with stack memory setting -Xss2m)
  def quickSortRecurive(array: Array[Int]): Array[Int] = {
    quickSortRecursive(array, 0, array.length-1)
    array
  }

  private def quickSortRecursive[T:Ordering](array: Array[T], startIndex: Int, endIndex: Int): Unit = {
    if(startIndex < endIndex){
      val pivot = endIndex
      var currentPivot = startIndex
      Range(startIndex, pivot).foreach { index =>
        if (array(index) < array(pivot)) {
          swap(array, index, currentPivot)
          currentPivot += 1
        }
      }
      swap(array, currentPivot, pivot)
      quickSortRecursive(array, startIndex, currentPivot-1)
      quickSortRecursive(array, currentPivot+1, endIndex)
    }
  }

  def quickSortOptimized(array: Array[Int]): Array[Int] = {
    quickSortOptimized(array, 0, array.length-1)
    array
  }

  private def quickSortOptimized[T:Ordering](array: Array[T], startIndex: Int, endIndex: Int): Unit = {
    var start = startIndex
    var end = endIndex
    while(start < end){
      val pivot = end
      var currentPivot = start
      Range(start, pivot).foreach { index =>
        if (array(index) < array(pivot)) {
          swap(array, index, currentPivot)
          currentPivot += 1
        }
      }
      swap(array, currentPivot, pivot)

      if(currentPivot - start < end - currentPivot){
        quickSortOptimized(array, start, currentPivot -1)
        start = currentPivot + 1
      } else {
        quickSortOptimized(array, currentPivot + 1, end)
        end = currentPivot - 1
      }
    }
  }
}
