package _118.kotlin

/**
 * @author relish
 * @since 2018/05/03
 */
class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val list = ArrayList<ArrayList<Int>>()
        for (i in 0 until numRows) {
            val item = ArrayList<Int>()
            item.add(1)
            if (i > 1) {
                for (j in 1 until i) {
                    val prev = list[i - 1]
                    item.add(prev[j - 1] + prev[j])
                }
            }
            if (i > 0) item.add(1)
            list.add(item)
        }
        return list
    }
}

fun main(args: Array<String>) {
    val message = Solution().generate(10)
    for(item in message){
        println(item)
    }
}
//2 3 4 5 6 7 8
//3 6 10 15 21 28
