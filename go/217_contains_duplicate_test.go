package leetcodego

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestContainsDuplicate(t *testing.T) {
	tests := []struct {
		args     []int
		expected bool
	}{
		{
			args:     []int{1, 2, 3, 1},
			expected: true,
		},
		{
			args:     []int{1, 2, 3, 4},
			expected: false,
		},
		{
			args:     []int{1, 1, 1, 3, 3, 4, 3, 2, 4, 2},
			expected: true,
		},
	}

	for _, test := range tests {
		got := ContainsDuplicate(test.args)
		assert.Equal(t, test.expected, got, "expected = %v - want = %v", test.expected, got)
	}
}
