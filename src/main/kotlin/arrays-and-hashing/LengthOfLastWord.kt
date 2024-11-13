package su.china.arrays

fun lengthOfLastWord(s: String): Int {
    val words = s.split(" ").filter { it.isNotEmpty() }
    return words.last().length
}

fun lengthOfLastWordSimple(s: String): Int {
    var i = s.lastIndex
    var res = 0
    while (s[i] == ' ') {
        i--
    }
    while (i > 0 && s[i] != ' ') {
        res++
        i--
    }
    return res
}