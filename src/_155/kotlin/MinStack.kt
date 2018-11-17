package _155.kotlin

/**
 * @author relish
 * @since 2018/11/16
 */
class MinStack() {

    var top: Node? = null

    /** initialize your data structure here. */
    class Node(var data: Int, var min: Int, var prev: Node?)

    fun push(x: Int) {
        top = if (top == null) {
            Node(x, x, null)
        } else {
            val min = Math.min(x, top!!.min)
            Node(x, min, top)
        }
    }

    fun pop() {
        if (top == null) throw Exception("Empty Stack.")
        top = if (top!!.prev == null) {
            null
        } else {
            Node(top!!.prev!!.data, top!!.prev!!.min, top!!.prev!!.prev)
        }
    }

    fun top(): Int {
        if (top == null) throw Exception("Empty Stack.")
        return top!!.data
    }

    fun getMin(): Int {
        if (top == null) throw Exception("Empty Stack.")
        return top!!.min
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */