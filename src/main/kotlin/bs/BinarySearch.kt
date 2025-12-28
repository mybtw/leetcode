package su.china.bs

fun search(nums: IntArray, target: Int): Int {
    var right = nums.size - 1
    var left = 0
    while (left < right) {
        val mid = left + (right - left) / 2
        if (nums[mid] == target) {
            return 1
        } else if (nums[mid] > target) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return -1
}
