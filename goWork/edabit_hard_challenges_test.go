package goWork

import (
	"goWork/internal/util"
	"testing"
	"time"
)

func TestPinValidation(t *testing.T) {
	t.Run("testing PinValidation function", func(t *testing.T) {
		util.Assert(t, PinValidation("1234"))
		util.Assert(t, PinValidation("123456"))
		util.AssertEqual(t, false, PinValidation("12 4"))
		util.AssertEqual(t, false, PinValidation(""))
		util.AssertEqual(t, false, PinValidation("123456789"))
	})
}

func TestOddishEvenish(t *testing.T) {
	t.Run("testing OddishEvenish function", func(t *testing.T) {
		util.AssertEqual(t, Evenish, OddishEvenish(11))
		util.AssertEqual(t, Oddish, OddishEvenish(111))
		util.AssertEqual(t, Evenish, OddishEvenish(1111))
		util.AssertEqual(t, Oddish, OddishEvenish(11111))
	})
}

func TestDaysBetween(t *testing.T) {
	t.Run("testing DaysBetween function", func(t *testing.T) {
		util.AssertEqual(t, -2, DaysBetween(time.Date(2024, time.August, 20, 0, 0, 0, 0, time.Local), time.Date(2024, time.August, 18, 0, 0, 0, 0, time.Local)))
		util.AssertEqual(t, 0, DaysBetween(time.Date(2024, time.August, 20, 0, 0, 0, 0, time.Local), time.Date(2024, time.August, 20, 0, 0, 0, 0, time.Local)))
		util.AssertEqual(t, 2, DaysBetween(time.Date(2024, time.August, 20, 0, 0, 0, 0, time.Local), time.Date(2024, time.August, 22, 0, 0, 0, 0, time.Local)))
	})
}

func TestCalculateBill(t *testing.T) {
	t.Run("testing CalculateBill function", func(t *testing.T) {
		util.AssertEqual(t, float32(19.45), CalculateBill([]Grocery{Grocery{"milk", 1, 1.50}, Grocery{"butter", 4, 2.99}, Grocery{"beans", 1, 5.99}}))
		util.AssertEqual(t, float32(3.00), CalculateBill([]Grocery{Grocery{"milk", 2, 1.50}}))
		util.AssertEqual(t, float32(0.0), CalculateBill([]Grocery{}))
	})
}
