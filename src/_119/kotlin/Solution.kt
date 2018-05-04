package _119.kotlin

/**
 * @author relish
 * @since 2018/05/05
 */
class Solution {
    fun getRow1(rowIndex: Int): List<Int> {
        val list = Array(rowIndex + 1, { i -> Array(i + 1, { 1 }) })
        for (i in 0 until rowIndex + 1) {
            for (j in 0 until i) {
                if (j == 0 || j == i) {
                    list[i][j] = 1
                } else {
                    list[i][j] = list[i - 1][j - 1] + list[i - 1][j]
                }
            }
        }
        return list[rowIndex].asList()
    }

    fun getRow(rowIndex: Int): List<Int> {
        val res = Array(rowIndex + 1, { 1 })
        for (i in 1 until rowIndex + 1) {
            if (i > (rowIndex + 1) / 2) {
                res[i] = res[rowIndex - i]
                continue
            }
            res[i] = ((res[i - 1]) * (rowIndex - i + 1).toLong() / i).toInt()
        }
        return res.asList()
    }
}

fun main(args: Array<String>) {
    println(Solution().getRow(3))
    println(Solution().getRow(30))
}