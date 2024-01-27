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

var Evenish string = "Evenish"
var Oddish string = "Oddish"

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
