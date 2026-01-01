package su.china

val directions = arrayOf(
    intArrayOf(0, 1),
    intArrayOf(1, 0),
    intArrayOf(0, -1),
    intArrayOf(-1, 0)
)

fun latestDayToCross(row: Int, col: Int, cells: Array<IntArray>): Int {
    var res = 0
    var left = 0
    var right = cells.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        val matrix = getFilledMatrix(row, col, cells, mid)
        var isPossible = false
        val visited = Array(row) { IntArray(col) }
        for (i in 0..matrix[0].size - 1) {
            if (matrix[0][i] == 0) {
                isPossible = isPossible || checkPath(matrix, visited, 0, i)
            }
        }
        if (isPossible) {
            res = mid
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return res + 1
}

fun checkPath(matrix: Array<IntArray>, visited: Array<IntArray>, row: Int, column: Int): Boolean {
    if (row >= matrix.size || row < 0 || column >= matrix[0].size || column < 0 || matrix[row][column] == 1
        || visited[row][column] == 1
    ) {
        return false
    }
    if (row == matrix.size - 1 && matrix[row][column] == 0) {
        return true
    }
    var res = false
    visited[row][column] = 1
    for (el in directions) {
        res = res || checkPath(matrix, visited, row + el[0], column + el[1])
    }
    return res
}

fun getFilledMatrix(row: Int, col: Int, cells: Array<IntArray>, day: Int): Array<IntArray> {
    val arr = Array(row) { IntArray(col) }
    for (i in 0..day) {
        val cell = cells[i]
        arr[cell[0] - 1][cell[1] - 1] = 1
    }
    return arr
}
