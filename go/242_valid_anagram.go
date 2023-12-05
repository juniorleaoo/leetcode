package leetcodego

func IsAnagram1(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	hashmapS := make(map[string]int)
	hashmapT := make(map[string]int)
	for i := 0; i < len(s); i++ {
		hashmapS[string(s[i])]++
		hashmapT[string(t[i])]++
	}

	for key, valueS := range hashmapS {
		valueT, ok := hashmapT[key]
		if !ok || valueT != valueS {
			return false
		}
	}

	return true
}

func IsAnagram2(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	hashmapS := make(map[string]int)
	for i := 0; i < len(s); i++ {
		hashmapS[string(s[i])]++
	}

	for _, char := range t {
		valueS, ok := hashmapS[string(char)]
		valueS--
		if !ok || valueS < 0 {
			return false
		}
		hashmapS[string(char)] = valueS
	}

	return true
}

func IsAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	hashmap := make(map[rune]int)
	for i := range s {
		hashmap[rune(s[i])]++
		hashmap[rune(t[i])]--
	}

	for _, value := range hashmap {
		if value != 0 {
			return false
		}
	}

	return true
}
