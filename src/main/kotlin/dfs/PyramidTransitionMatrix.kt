package su.china.dfs


fun pyramidTransition(bottom: String, allowed: List<String>): Boolean {
    val triangles = mutableMapOf<Int, MutableList<Int>>()
    allowed.forEach { e ->
        val key = (e[0] - 'A') * 6 + (e[1] - 'A')
        val value = e[2] - 'A'
        triangles.getOrPut(key) { mutableListOf() }.add(value)
    }
    return pyramidTransitionHelper(bottom, "", 0, triangles, mutableSetOf())
}

fun pyramidTransitionHelper(
    bottom: String,
    above: String,
    idx: Int,
    allowed: Map<Int, List<Int>>,
    failed: MutableSet<String>
): Boolean {
    if (bottom.length == 1) return true

    val state = "$bottom|$idx|$above"
    if (state in failed) return false

    if (idx == bottom.length - 1) {
        val ok = pyramidTransitionHelper(above, "", 0, allowed, failed)
        if (!ok) failed.add(state)
        return ok
    }

    val key = (bottom[idx] - 'A') * 6 + (bottom[idx + 1] - 'A')
    val tops = allowed[key] ?: run {
        failed.add(state)
        return false
    }

    for (el in tops) {
        if (pyramidTransitionHelper(bottom, above + ('A' + el), idx + 1, allowed, failed)) return true
    }

    failed.add(state)
    return false
}



