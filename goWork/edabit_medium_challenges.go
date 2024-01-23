package goWork

import "regexp"

// Create a function that accepts a list of booleans and returns a count for how many are true
func countTrue(values []bool) int {
	var counter = 0
	for i := 0; i < len(values); i++ {
		if values[i] {
			counter += 1
		}
	}
	return counter
}

// Create a function that accepts a string and returns a function that returns that string
func redundant(value string) func() string {
	return func() string { return value }
}

// Create a RegEx to check for an empty string
// Compile regex outside of method call since regex compilation is expensive
var emptyRegEx, _ = regexp.Compile("^$") // bad scope
func regExEmptyString(value string) bool {
	return emptyRegEx.MatchString(value)
}
