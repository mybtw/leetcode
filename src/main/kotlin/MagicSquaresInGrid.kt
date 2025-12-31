package su.china

fun numMagicSquaresInside(grid: Array<IntArray>): Int {
    var res = 0
    for (i in 0..grid.size - 1) {
        for (j in 0..grid[i].size - 1) {
            if (i + 2 < grid.size && j + 2 < grid[i].size && isDistinctAndAllowed(grid, i, j)) {
                val sum = grid[i][j] + grid[i][j + 1] + grid[i][j + 2]
                var isEq = true
                for (i1 in i..i + 2) {
                    var rowSum = 0
                    for (j1 in j..j + 2) {
                        rowSum += grid[i1][j1]
                    }
                    isEq = isEq && (rowSum == sum)
                }
                for (j1 in j..j + 2) {
                    var columnSum = 0
                    for (i1 in i..i + 2) {
                        columnSum += grid[i1][j1]
                    }
                    isEq = isEq && (columnSum == sum)
                }
                var firstDiagSum = 0
                for (k in 0..2) {
                    firstDiagSum += grid[i + k][j + k]
                }
                isEq = isEq && (firstDiagSum == sum)
                var secondDiagSum = 0
                for (k in 0..2) {
                    secondDiagSum += grid[i + k][j + 2 - k]
                }
                isEq = isEq && (secondDiagSum == sum)

                if (isEq) {
                    res = res + 1
                }
            }
        }
    }
    return res
}

fun isDistinctAndAllowed(grid: Array<IntArray>, i: Int, j: Int): Boolean {
    val occurrences = IntArray(10)
    if (grid[i + 1][j + 1] != 5) {
        return false
    }
    for (x in i..i + 2) {
        for (y in j..j + 2) {
            val elem = grid[x][y]
            if (elem > 9 || elem == 0) {
                return false
            }
            occurrences[elem] += 1
            if (occurrences[elem] > 1) {
                return false
            }
        }
    }
    return true
}