package su.china

fun main() {
    val testArr = intArrayOf(2, 0, 2, 1, 1, 0)
    println(sortColors(testArr))
    testArr.forEach { el -> println(el) }
}

fun sortColors(nums: IntArray): Unit {
    val cntArr = IntArray(3)
    for (i in nums.indices) {
        when (nums[i]) {
            0 -> cntArr[0]++
            1 -> cntArr[1]++
            2 -> cntArr[2]++
        }
    }
    for (i in 0..<cntArr[0]) {
        nums[i] = 0
    }
    for (i in cntArr[0]..<cntArr[0] + cntArr[1]) {
        nums[i] = 1
    }
    for (i in cntArr[0] + cntArr[1] ..nums.lastIndex) {
        nums[i] = 2
    }
}

fun guess(num: Int): Int {
    return 0
}

fun guessNumber(n: Int): Int {
    var left = 1
    var right = n
    while (left <= right) {
        var mid = left + (right - left) / 2
        when (val guessing: Int = (guess(mid))) {
            0 -> return mid
            -1 -> right = mid - 1
            else -> left = mid + 1
        }
    }
    return -1
}

fun singleNonDuplicate(nums: IntArray): Int {
    var left = 0
    var right = nums.lastIndex
    while (left <= right) {
        val mid = left + (right - left) / 2
        val midElementEqualsRight = mid + 1 < nums.size && nums[mid] == nums[mid + 1]
        val midElementEqualsLeft = mid - 1 >= 0 && nums[mid] == nums[mid - 1]
        when {
            !midElementEqualsRight && !midElementEqualsLeft -> return nums[mid]
            midElementEqualsLeft -> if ((mid + 1) % 2 == 0) left = mid + 1 else right = mid - 1
            else -> if ((nums.lastIndex - mid + 1) % 2 == 0) right = mid - 1 else left = mid + 1
        }
    }
    return -1
}

