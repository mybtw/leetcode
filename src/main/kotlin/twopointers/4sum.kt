package su.china.twopointers

import java.util.LinkedList

const val kSize = 4

fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    val temp = LinkedList<Int>()
    val res = LinkedList<LinkedList<Int>>()
    if (nums.size < 4) return res
    nums.sort()
    ksum(res, nums, temp, target.toLong(), 0, kSize)
    return res
}

fun ksum(res: LinkedList<LinkedList<Int>>, nums: IntArray, temp: LinkedList<Int>, target: Long, start: Int, k: Int ) {
    val n = nums.size
    if (k * nums[start].toLong() > target || k * nums[n - 1].toLong() < target) return
    if (k != 2) {
        for (i in start..n - k) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue
            }
            temp.add(nums[i])
            ksum(res, nums, temp, target - nums[i], i + 1, k - 1)
            temp.removeLast()
        }
    }
    var left = start
    var right = nums.lastIndex
    while (left < right && temp.size == kSize - 2) {
        val sum = nums[left].toLong() + nums[right].toLong()
        when  {
            sum == target -> {
                temp.add(nums[left])
                temp.add(nums[right])
                res.add(LinkedList(temp))
                temp.removeLast()
                temp.removeLast()
                left++
                while (left < right && nums[left - 1] == nums[left]) {
                    left++
                }
            }
            sum < target -> left++
            else -> right--
        }
    }
}
