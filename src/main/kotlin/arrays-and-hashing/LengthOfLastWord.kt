package su.china.arrays

fun lengthOfLastWord(s: String): Int {
    val words = s.split(" ").filter { it.isNotEmpty() }
    return words.last().length
}