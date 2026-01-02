package su.china

import kotlin.math.min

fun minimumCost(cost1: Int, cost2: Int, costBoth: Int, need1: Int, need2: Int): Long {
    var res = 0L
    if (costBoth < cost1 + cost2) {
        val minAmount = min(need1, need2)
        res += minAmount.toLong() * costBoth.toLong()
        res += (need1 - minAmount).toLong() * min(cost1, costBoth).toLong()
        res += (need2 - minAmount).toLong() * min(cost2, costBoth).toLong()
    } else {
        res += need1.toLong() * min(cost1, costBoth).toLong()
        res += need2.toLong() * min(cost2, costBoth).toLong()
    }
    return res
}