[xxxx][title]

## Description
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 - push(x) -- Push element x onto stack.
 - pop() -- Removes the element on top of the stack.
 - top() -- Get the top element.
 - getMin() -- Retrieve the minimum element in the stack.



**Example:**

```
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
```

**Tags:** 
`Stack`、`Design`


## 思路 1
实现简单的栈数据结构。  
有个需要注意的点是最小值的储存。可以做成一个min值的Node链, 但并不高效; 
最次的就是在获取最小值的方法里遍历得到最小值;
我这里的做法是把最小值存在每个Node里。由于这是栈结构, 先进后出, 每个节点(Node)里的min的值意为: 从当前节点到栈底的所有节点里的最小值。
java(56ms/100.00%): 
```java
class MinStack {

    Node top = null;

    class Node {
        int data;
        int min;
        Node prev;

        public Node(int data, int min, Node prev) {
            this.data = data;
            this.min = min;
            this.prev = prev;
        }
    }

    /**
     * initialize your data structure here.
     */
    public MinStack() {
    }

    public void push(int x) {
        if (top == null) {
            top = new Node(x, x, null);
        } else {
            int min = Math.min(x, top.min);
            Node t = top;
            top = new Node(x, min, t);
        }
    }

    public void pop() {
        Node prev = top.prev;
        if (prev == null) {
            top = null;
        } else {
            top = new Node(prev.data, prev.min, prev.prev);
        }
    }

    public int top() {
        return top.data;
    }

    public int getMin() {
        return top.min;
    }
}    
```

```javascript
var MinStack = function() {
  this.stack = []
};

/** 
* @param {number} x
* @return {void}
*/
MinStack.prototype.push = function(x) {
  let min = this.stack.length === 0 ? x : this.stack[this.stack.length - 1].min
  this.stack.push({val: x, min: Math.min(min, x)})
};

/**
* @return {void}
*/
MinStack.prototype.pop = function() {
  if(this.stack.length > 0){
      this.stack.pop()
  }
};

/**
* @return {number}
*/
MinStack.prototype.top = function() {
  if(this.stack.length > 0) {
      return this.stack[this.stack.length - 1].val
  }
};

/**
* @return {number}
*/
MinStack.prototype.getMin = function() {
  if(this.stack.length > 0) {
      return this.stack[this.stack.length - 1].min
  }
};

```
## 结语
   
如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/xxxx
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution