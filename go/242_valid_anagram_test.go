package leetcodego

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestValidAnagram(t *testing.T) {
	tests := []struct {
		s        string
		t        string
		expected bool
	}{
		{
			s:        "anagram",
			t:        "nagaram",
			expected: true,
		},
		{
			s:        "rat",
			t:        "car",
			expected: false,
		},
	}

	for _, test := range tests {
		got := IsAnagram(test.s, test.t)
		assert.Equal(t, test.expected, got, "expected = %v - want = %v", test.expected, got)
	}
}
