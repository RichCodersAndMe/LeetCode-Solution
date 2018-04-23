[Baseball Game][title]

## Description

You're now a baseball game point recorder.

Given a list of strings, each string can be one of the 4 following types:

1. `Integer` (one round's score): Directly represents the number of points you get in this round.
2. `"+"` (one round's score): Represents that the points you get in this round are the sum of the last two `valid` round's points.
3. `"D"` (one round's score): Represents that the points you get in this round are the doubled data of the last `valid` round's points.
4. `"C"` (an operation, which isn't a round's score): Represents the last `valid` round's points you get were invalid and should be removed.

Each round's operation is permanent and could have an impact on the round before and the round after.

You need to return the sum of the points you could get in all the rounds.

**Example 1:**

```
Input: ["5","2","C","D","+"]
Output: 30
Explanation: 
Round 1: You could get 5 points. The sum is: 5.
Round 2: You could get 2 points. The sum is: 7.
Operation 1: The round 2's data was invalid. The sum is: 5.  
Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 15.
Round 4: You could get 5 + 10 = 15 points. The sum is: 30.
```

**Example 2:**

```
Input: ["5","-2","4","C","D","9","+","+"]
Output: 27
Explanation: 
Round 1: You could get 5 points. The sum is: 5.
Round 2: You could get -2 points. The sum is: 3.
Round 3: You could get 4 points. The sum is: 7.
Operation 1: The round 3's data is invalid. The sum is: 3.  
Round 4: You could get -4 points (the round 3's data has been removed). The sum is: -1.
Round 5: You could get 9 points. The sum is: 8.
Round 6: You could get -4 + 9 = 5 points. The sum is 13.
Round 7: You could get 9 + 5 = 14 points. The sum is 27.
```

**Note:**

- The size of the input list will be between 1 and 1000.
- Every integer represented in the list will be between -30000 and 30000.

## 思路

整数代表所得分数；`+`代表所得分数为最后两回合的有效分数的和；`D`代表所得分数为最后一回合的有效分数的两倍；`C`代表最后一回合的分数无效。按题意计算分数即可。

**Java:**

```java
public int calPoints(String[] ops) {
    int[] scores = new int[1000];
    int sum = 0;
    int i = 0;

    for (String op : ops) {
        if (op.charAt(0) == 'C') {
            sum -= scores[i--];
            continue;
        }

        i++;
        if (op.charAt(0) == '+') {
            scores[i] = scores[i-1] + scores[i-2];
        } else if (op.charAt(0) == 'D') {
            scores[i] = scores[i - 1] * 2;
        } else {
            scores[i] = Integer.valueOf(op);
        }
        sum += scores[i];
    }

    return sum;
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/baseball-game/description/
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution