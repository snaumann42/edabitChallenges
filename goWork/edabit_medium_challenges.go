package goWork

import "regexp"

// Create a function that accepts a list of booleans and returns a count for how many are true
func CountTrue(values []bool) int {
	var counter = 0
	for i := 0; i < len(values); i++ {
		if values[i] {
			counter += 1
		}
	}
	return counter
}

// Create a function that accepts a string and returns a function that returns that string
func Redundant(value string) func() string {
	return func() string { return value }
}

// Create a RegEx to check for an empty string
// Compile regex outside of method call since regex compilation is expensive
var emptyRegEx, _ = regexp.Compile("^$")
func RegExpEmptyString(value string) bool {
	return emptyRegEx.MatchString(value)
}

// Create a function that takes two numbers as arguments (num, length) and
// returns an slice of multiples of num until the list length reaches length.
func SliceOfMultiples(num int, length int) []int {
	var multiple = []int{}
	for i := 1; i <= length; i++ {
		multiple = append(multiple, num*i)
	}
	return multiple
}

// Given a list of positive numbers, sum up the Odds and Even numbers separately and
// return the difference (larger sum - smaller sum)
func WarOfNumbers(numbers []int) int {
	var evenSum = 0
	var oddSum = 0
	for i := 0; i < len(numbers); i++ {
		if numbers[i]%2 == 0 {
			evenSum += numbers[i]
		} else {
			oddSum += numbers[i]
		}
	}
	return Abs(evenSum - oddSum)
}

// Utility function for War Of Numbers
func Abs(num int) int {
	if num < 0 {
		return -num
	}
	return num
}

// Create a function that finds the sum of an Slice recursively
func SquarePatch(value int) [][]int {
	var internalList = []int{}
	var externalList = [][]int{}

	// Create internal slice
	for i := 0; i < value; i++ {
		internalList = append(internalList, value)
	}

	// Build external slice
	for i := 0; i < value; i++ {
		externalList = append(externalList, internalList)
	}

	return externalList
}

// Create a function that finds the sum of an slice recursively
func RecursiveSum(values []int) int {
	switch len(values) {
	case 0:
		return 0
	case 1:
		return values[0]
	default:
		return values[0] + RecursiveSum(values[1:])
	}
}
