package goWork

import (
	"testing"
	"goWork/internal/util"
)

func TestCountBoolean(t *testing.T) {
	t.Run("testing boolean count function", func(t *testing.T) {
		util.AssertEqual(t, 3, CountTrue([]bool{true, false, true, true}))
		util.AssertEqual(t, 0, CountTrue([]bool{false, false, false}))
		util.AssertEqual(t, 0, CountTrue([]bool{}))
	})
}

func TestRedundant(t *testing.T) {
	t.Run("testing redundant function", func(t *testing.T) {
		var apple = "apple"
		var pear = "pear"
		var empty = ""

		util.AssertEqual(t, apple, Redundant(apple)())
		util.AssertEqual(t, pear, Redundant(pear)())
		util.AssertEqual(t, empty, Redundant(empty)())
	})
}

func TestEmptyRegexp(t *testing.T) {
	t.Run("testing empty regexp function", func(t *testing.T) {
		util.Assert(t, RegExpEmptyString(""))
		util.Assert(t, !RegExpEmptyString("\n"))
		util.Assert(t, !RegExpEmptyString(" "))
	})
}

func TestSliceOfMultiples(t *testing.T) {
	t.Run("testing slice of multiples function", func(t *testing.T) {
		util.AssertEqualDeep(t, []int{7, 14, 21, 28, 35}, SliceOfMultiples(7, 5))
		util.AssertEqualDeep(t, []int{2}, SliceOfMultiples(2, 1))
		util.AssertEqualDeep(t, []int{}, SliceOfMultiples(2, 0))
	})
}

func TestWarOfNumbers(t *testing.T) {
	t.Run("testing war of numbers function", func(t *testing.T) {
		util.AssertEqual(t, 3, WarOfNumbers([]int{8, 5}))
		util.AssertEqual(t, 5, WarOfNumbers([]int{1, 2, 3, 4, 5, 6, 7, 8, 9}))
		util.AssertEqual(t, 0, WarOfNumbers([]int{50, 100, 149, 1, 200, 199, 3, 2}))
		util.AssertEqual(t, 0, WarOfNumbers([]int{}))
	})
}

func TestSquarePatch(t *testing.T) {
	t.Run("testing square patch function", func(t *testing.T) {
		util.AssertEqualDeep(t, [][]int{{2, 2}, {2, 2}}, SquarePatch(2))
		util.AssertEqualDeep(t, [][]int{{3, 3, 3}, {3, 3, 3}, {3, 3, 3}}, SquarePatch(3))
		util.AssertEqualDeep(t, [][]int{{1}}, SquarePatch(1))
		util.AssertEqualDeep(t, [][]int{}, SquarePatch(0))
	})
}

func TestRecursiveSum(t *testing.T) {
	t.Run("testing recursive sum function", func(t *testing.T) {
		util.AssertEqual(t, 10, RecursiveSum([]int{1, 2, 3, 4}))
		util.AssertEqual(t, -3, RecursiveSum([]int{-1, -1, -1}))
		util.AssertEqual(t, 1, RecursiveSum([]int{1}))
		util.AssertEqual(t, 0, RecursiveSum([]int{}))
	})
}

