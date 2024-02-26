package goWork

import (
	"regexp"
	"strconv"
	"time"
)

// Regex validate pin, allow for only 4 or 6 characters and only numeric, no whitespace
var pinRegEx, _ = regexp.Compile("^\\d{4}$|^\\d{6}$")

func PinValidation(pin string) bool {
	return pinRegEx.MatchString(pin)
}

const Evenish string = "Evenish"
const Oddish string = "Oddish"

// Return if the number parameter is oddish or evenish, a number is oddish
// if all of it's digits add up to an odd number and evenish if it's digits
// add up to an even number.
func OddishEvenish(value int) string {
	var intString string = strconv.Itoa(value)
	var stringSum int64 = 0
	for i := 0; i < len(intString); i++ {
		var value, _ = strconv.ParseInt(string(intString[i]), 10, 64)
		stringSum = value + stringSum
	}
	if stringSum%2 == 0 {
		return Evenish
	} else {
		return Oddish
	}
}

// Calculate how many days there are inbetween two dates
func DaysBetween(startDate time.Time, endDate time.Time) int {
	var days = endDate.Sub(startDate).Hours() / 24
	return int(days)
}

type Grocery struct {
	Product  string
	Quantity int
	Price    float32
}

func CalculateBill(groceries []Grocery) float32 {
	var total float32 = 0
	for i := 0; i < len(groceries); i++ {
		total = total + (groceries[i].Price * float32(groceries[i].Quantity))
	}
	return total
}

type TrackingTuple[T int | int64 | float64 | string] struct {
	index int
	value T
	count int
}

// Calculate the frequencies of the given type and
// the returned object should contain them in the order received.
// Created a generic method to handle string and numeric types.
func FrequencyDistribution[T int | int64 | float64 | string](values []T) []TrackingTuple[T] {
	var frequencyMap = make(map[T]TrackingTuple[T])
	var index = 0

	for value := range values {
		var currentValue = values[value]
		mapValue, exists := frequencyMap[currentValue]
		if exists {
			mapValue.count += 1                   // update the counter
			frequencyMap[currentValue] = mapValue // TrackingTuple[T]{frequencyMap[currentValue].index, currentValue, frequencyMap[currentValue].count+1}
		} else {
			frequencyMap[currentValue] = TrackingTuple[T]{index, currentValue, 1}
			index += 1
		}
	}
	return []TrackingTuple[T]{}
	/*return sort.Slice(map.Values(frequencyMap), func(i, j int) bool {
		return planets[i].Axis < planets[j].Axis
	})*/
}

/*
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
}*/
