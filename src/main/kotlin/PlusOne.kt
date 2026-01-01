package su.china

// you can iterate form last elem and keep track of suffixMin and prefixSum instead of using 2 arrays
fun maximumScore(nums: IntArray): Long {
    val prefixSum = LongArray(nums.size) { 0 }
    prefixSum[0] = nums[0].toLong()
    for (i in 1..nums.size - 1) {
        prefixSum[i] = prefixSum[i - 1] + nums[i]
    }
    val suffixMin = IntArray(nums.size) { 0 }
    suffixMin[nums.size - 1] = nums[nums.size - 1]
    for (i in nums.size - 2 downTo 0) {
        suffixMin[i] = nums[i].coerceAtMost(suffixMin[i + 1])
    }
    var res: Long = Long.MIN_VALUE
    for (i in 0..nums.size - 2) {
        res = res.coerceAtLeast(prefixSum[i] - suffixMin[i + 1])
    }
    return res
}