package util

import (
	"reflect"
	"testing"
)

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