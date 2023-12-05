package leetcodego

// one-pass hash table
func TwoSum(nums []int, target int) []int {
	var values = make(map[int]int)

	for i, num := range nums {
		diff := target - num
		if j, ok := values[diff]; ok {
			return []int{j, i}
		}
		values[num] = i
	}
	return nil
}

func TwoSumBruteForceSolution(nums []int, target int) []int {
	var result []int

	for i := 0; i < len(nums); i++ {

		for j := i + 1; j <= len(nums)-1; j++ {
			num1 := nums[i]
			num2 := nums[j]
			if num1+num2 == target {
				result = append(result, i)
				result = append(result, j)
				break
			}
		}

		if result != nil {
			break
		}
	}

	return result
}
