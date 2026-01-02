package su.china

fun repeatedNTimes(nums: IntArray): Int {
    val freq = mutableMapOf<Int, Int>()

    for (x in nums) {
        freq[x] = (freq[x] ?: 0) + 1
    }

    for (x in nums) {
        if (freq[x] == (nums.size / 2)) {
            return x
        }
    }

    return -1
}