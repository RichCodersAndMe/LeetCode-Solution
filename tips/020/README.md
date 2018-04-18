# [Valid Parentheses][title]

## Description

Given a string containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

The brackets must close in the correct order, `"()"` and `"()[]{}"` are all valid but `"(]"` and `"([)]"` are not.

**Tags:** Stack, String


## 思路

题意是判断括号匹配是否正确，很明显，我们可以用栈来解决这个问题，当出现左括号的时候入栈，当遇到右括号时，判断栈顶的左括号是否何其匹配，不匹配的话直接返回 `false` 即可，最终判断是否空栈即可，这里我们可以用数组模拟栈的操作使其操作更快，有个细节注意下 `top =  1;`，从而省去了之后判空的操作和 `top - 1` 导致数组越界的错误。
java:
```java
class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length() + 1];
        int top = 1;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack[top++] = c;
            } else if (c == ')' && stack[--top] != '(') {
                return false;
            } else if (c == ']' && stack[--top] != '[') {
                return false;
            } else if (c == '}' && stack[--top] != '{') {
                return false;
            }
        }
        return top == 1;
    }
}
```
kotlin:
用了`java.util.*`里的类——`Stack`。思路与上面的Java代码一致。
```
class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        val map = mapOf(')' to '(', ']' to '[', '}' to '{')
        return s.all {
            if (it !in map) {
                stack.add(it)
            } else {
                !stack.isEmpty() && stack.pop() == map[it]
            }
        } && stack.isEmpty()
    }
}
```
JavaScrip:
```JavaScript
var isValid = function(s) {
    if (s === '') {
        return true
    }
    if (s.length % 2 !== 0) {
        return false
    } else {
		var strArr1 = []
        var num = 0
        for (var i = 0; i < s.length; i++) {
            if (isLeft(s[i])) {
                strArr1.push(s[i])
            } else {
				var pop = strArr1.pop()
                if (!squre(pop, s[i])) {
					console.log(pop)
                    return false
                }
            }
        }
        return (strArr1.length === 0)

    }
    function isLeft(a) {
        return (a==='{'||a==='['||a==='(')
    }
    function squre(a,b) {
        if ((a ==='[' && b ===']') || (a ==='{' && b ==='}') || (a ==='(' && b ===')')) {
            return true
        } else {
            return false
        }
    }
};

```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]



[title]: https://leetcode.com/problems/valid-parentheses
[ls]: https://github.com/SDE603/LeetCode-Solution
