import ch.tutteli.atrium.api.fluent.en_GB.*
import ch.tutteli.atrium.api.verbs.expect
import java.io.File
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.collections.mutableMapOf
import kotlin.collections.plusAssign
import kotlin.collections.set
import kotlin.collections.toList
import kotlin.collections.toTypedArray
import kotlin.test.assertContains
import kotlin.test.assertTrue
import kotlin.test.expect
import kotlin.text.Charsets
import kotlin.text.StringBuilder
import kotlin.text.set

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val result = mutableMapOf<String, MutableList<String>>()

    for (s1 in strs) {
        val s1Sorted = sortStr(s1)
        if (result[s1Sorted] == null) {
            result[s1Sorted] = mutableListOf(s1)
        } else {
            val anagrams = result[s1Sorted]
            if (anagrams != null) {
                anagrams += s1
            }
        }
    }

    return result.values.toList()
}

fun sortStr(str: String): String {
    val strBuilder = StringBuilder(str)
    val len = strBuilder.length

    for (i in 0 until len - 1) {
        for (j in 0 until len - i - 1) {
            if (strBuilder[j] > strBuilder[j + 1]) {
                val temp = strBuilder[j]
                strBuilder[j] = strBuilder[j + 1]
                strBuilder[j + 1] = temp
            }
        }
    }
    return strBuilder.toString()
}

fun main(strs: Array<String>) {
    val result = groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
    assertTrue(result.size == 3)
    expect(result.find { it.size == 1 }).notToEqualNull().toContain.inAnyOrder.only.values("bat")
    expect(result.find { it.size == 2 }).notToEqualNull().toContain.inAnyOrder.only.values("nat", "tan")
    expect(result.find { it.size == 3 }).notToEqualNull().toContain.inAnyOrder.only.values("ate", "eat", "tea")

    val result1 = groupAnagrams(arrayOf(""))
    assertContains(result1, listOf(""))

    val result2 = groupAnagrams(arrayOf("a"))
    assertContains(result2, listOf("a"))

    val result3 = groupAnagrams(arrayOf("", ""))
    assertTrue(result3.size == 1)
    assertTrue(result3[0].size == 2)
    expect(result3[0]).toContain.inAnyOrder.only.values("", "")

    val result4 = groupAnagrams(arrayOf("eat", "", "tea", "", "tan", "", "ate", "nat", "bat", ""))
    assertTrue(result4.size == 4)
    expect(result4.find { it.size == 1 }).notToEqualNull().toContain.inAnyOrder.only.values("bat")
    expect(result4.find { it.size == 2 }).notToEqualNull().toContain.inAnyOrder.only.values("nat", "tan")
    expect(result4.find { it.size == 3 }).notToEqualNull().toContain.inAnyOrder.only.values("ate", "eat", "tea")
    expect(result4.find { it.size == 4 }).notToEqualNull().toContain.inAnyOrder.only.values("", "", "", "")

    val result5 = groupAnagrams(arrayOf("c", "c"))
    assertTrue(result5.size == 1)
    assertTrue(result5[0].size == 2)
    expect(result5[0]).toContain.inAnyOrder.only.values("c", "c")

    val result6 = groupAnagrams(arrayOf("ac", "c"))
    assertTrue(result6.size == 2)
    assertTrue(result6[0].size == 1)
    assertTrue(result6[1].size == 1)
}