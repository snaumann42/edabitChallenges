package goWork

import "testing"

func TestCountBoolean(t *testing.T) {
	t.Run("testing boolean count function", func(t *testing.T) {
		AssertEqual(t, 3, countTrue([]bool{true, false, true, true}))
		AssertEqual(t, 0, countTrue([]bool{false, false, false}))
		AssertEqual(t, 0, countTrue([]bool{}))
	})
}

func TestRedundant(t *testing.T) {
	t.Run("testing redundant function", func(t *testing.T) {
		var apple = "apple"
		var pear = "pear"
		var empty = ""

		AssertEqual(t, apple, redundant(apple)())
		AssertEqual(t, pear, redundant(pear)())
		AssertEqual(t, empty, redundant(empty)())
	})
}

func AssertEqual(t *testing.T, want, got interface{}) {
	t.Helper()
	if got != want {
		t.Errorf("wanted %+v, got %+v", want, got)
	}
}

func AssertNotEqual(t *testing.T, want, got interface{}) {
	t.Helper()
	if got == want {
		t.Errorf("didn't want %+v", got)
	}
}
