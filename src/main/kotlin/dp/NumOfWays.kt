package su.china.dp

//https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid
fun numOfWays(n: Int): Int {
    var aba = 6L
    var abc = 6L
    val mod = 1_000_000_007L
    repeat(n - 1) {
        val a = (3 * aba + 2 * abc) % mod
        val b = (2 * aba + 2 * abc) % mod
        aba = a
        abc = b
    }
    return ((aba + abc) % mod).toInt()
}