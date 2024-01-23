package goWork

import (
	"reflect"
	"testing"
)

func TestCountBoolean(t *testing.T) {
	t.Run("testing boolean count function", func(t *testing.T) {
		AssertEqual(t, 3, CountTrue([]bool{true, false, true, true}))
		AssertEqual(t, 0, CountTrue([]bool{false, false, false}))
		AssertEqual(t, 0, CountTrue([]bool{}))
	})
}

func TestRedundant(t *testing.T) {
	t.Run("testing redundant function", func(t *testing.T) {
		var apple = "apple"
		var pear = "pear"
		var empty = ""

		AssertEqual(t, apple, Redundant(apple)())
		AssertEqual(t, pear, Redundant(pear)())
		AssertEqual(t, empty, Redundant(empty)())
	})
}

func TestEmptyRegexp(t *testing.T) {
	t.Run("testing empty regexp function", func(t *testing.T) {
		Assert(t, RegExpEmptyString(""))
		Assert(t, !RegExpEmptyString("\n"))
		Assert(t, !RegExpEmptyString(" "))
	})
}

func TestSliceOfMultiples(t *testing.T) {
	t.Run("testing slice of multiples function", func(t *testing.T) {
		AssertEqualDeep(t, []int{7, 14, 21, 28, 35}, SliceOfMultiples(7, 5))
		AssertEqualDeep(t, []int{2}, SliceOfMultiples(2, 1))
		AssertEqualDeep(t, []int{}, SliceOfMultiples(2, 0))
	})
}

func TestWarOfNumbers(t *testing.T) {
	t.Run("testing redundant function", func(t *testing.T) {
		AssertEqual(t, 3, WarOfNumbers([]int{8, 5}))
		AssertEqual(t, 5, WarOfNumbers([]int{1, 2, 3, 4, 5, 6, 7, 8, 9}))
		AssertEqual(t, 0, WarOfNumbers([]int{50, 100, 149, 1, 200, 199, 3, 2}))
		AssertEqual(t, 0, WarOfNumbers([]int{}))
	})
}

func AssertEqual(t *testing.T, want, got interface{}) {
	t.Helper()
	if got != want {
		t.Errorf("wanted %+v, got %+v", want, got)
	}
}

func AssertEqualDeep(t *testing.T, want, got interface{}) {
	t.Helper()
	if !reflect.DeepEqual(want, got) {
		t.Errorf("wanted %+v, got %+v", want, got)
	}
}

func Assert(t *testing.T, got bool) {
	t.Helper()
	if !got {
		t.Errorf("We expected %+v to be true", got)
	}
}

func AssertNotEqual(t *testing.T, want, got interface{}) {
	t.Helper()
	if got == want {
		t.Errorf("didn't want %+v", got)
	}
}
