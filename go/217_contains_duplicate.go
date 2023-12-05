package leetcodego

func ContainsDuplicate(nums []int) bool {
	hashset := make(map[int]bool)
	for _, number := range nums {
		ok, _ := hashset[number]
		if ok {
			return true
		}
		hashset[number] = true
	}
	return false
}
