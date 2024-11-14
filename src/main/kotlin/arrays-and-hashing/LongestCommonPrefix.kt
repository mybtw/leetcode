package su.china.arrays

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    if (strs.size == 1) {
        return strs.first()
    }
    for (i in 0..strs.lastIndex) {
        if (strs[i].isEmpty()) {
            return "";
        }
    }
    var flag = true;
    var lastIndex = 0;
    while (flag) {
        for (index in 1..strs.lastIndex) {
            if (lastIndex > strs[index].lastIndex || lastIndex > strs[0].lastIndex || strs[index][lastIndex] != strs[0][lastIndex]) {
                flag = false
                break
            }
        }
        lastIndex++;
    }
    if (lastIndex > 0) {
        lastIndex--;
    }
    return strs[0].substring(0, lastIndex)
}
