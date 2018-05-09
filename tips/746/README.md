[Min Cost Climbing Stairs][title]

## Description

On a staircase, the `i`-th step has some non-negative cost `cost[i]` assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

**Example 1:**

```
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
```

**Example 2:**

```
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
```

**Note:**

1. `cost` will have a length in the range `[2, 1000]`.
2. Every `cost[i]` will be an integer in the range `[0, 999]`.

**Tags:** [Array](https://leetcode.com/tag/array/)、[Dynamic Programming](https://leetcode.com/tag/dynamic-programming/)


## 思路

题目给出一个楼梯，和一个数组`cost`对应爬每一阶楼梯所需要的花费。即，从下往上从0开始，爬第`i`阶所需要的花费为`cost[i]`。然后规定，当我们付出爬一阶所需要的花费后，我们可以往上爬一阶或者两阶，这可以理解成我们每爬一阶都可以选择免费再往上爬一阶（或者不）。另外，我们也可以选择从第0阶或者第1阶开始爬。现在需要我们计算爬完这段楼梯所需要的最少花费。

通过动态规划可以比较简单的解出此题，假设我们爬完第`i`阶所需要的最少花费为`minCost[i]`，那么

```
minCost[i] = cost[i] + min(minCost[i-1], minCost[i-2])
```

这就是我们的动态转移方程。关键在于“我们每一次前进，是选择前进一步，还是两步”这个问题上，爬完第`i`阶所需要的最少花费取决于之前我们是如何到达这个台阶的，我们有可能是从第`i-1`个台阶只前进一步到达，也有可能是从`i-2`个台阶前进两步到达。为此，我们需要知道爬完第`i-1`阶和爬完`i-2`阶所需要的最小花费，回溯到最开始，我们需要知道爬完第0阶和爬完第1阶所需要的最小花费，根据题意，它们分别是`cost[0]`和`cost[1]`。完成了`minCost`的初始化后，我们就可以通过迭代填完`minCost`。最后是要得到爬完楼梯所需要的最小花费，有可能是刚好爬完最后一阶楼梯所需要的花费，也有可能是爬完倒数第二阶（最后一次走两步）后所需要的花费。因此我们可以这样写：

**Java:**

```
public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length];
        minCost[0] = cost[0];
        minCost[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
                minCost[i] = cost[i] + Math.min(minCost[i - 1], minCost[i - 2]);
        }

        return Math.min(minCost[minCost.length - 1], minCost[minCost.length - 2]);
}
```

可以看出，每一次迭代我们仅仅需要知道`minCost[i-1]`和`minCost[i-2]`，我们可以通过两个变量来记录下这两个信息，减少空间开销。可以这样写：

**Java:**

```
public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length];
        int a = cost[0];
        int b = cost[1];

        for (int i = 2; i < cost.length; i++) {
                minCost[i] = cost[i] + Math.min(a, b);
                a = b;
                b = minCost[i];
        }

        return Math.min(a, b);
}
```

又或者因为`cost`数组的每个数据仅在迭代的时候使用一次，我们可以直接把`cost`数组当做`minCost`数组用，这样就不需要其他的空间开销。可以这样写：

**Java:**

```
public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
                cost[i] = cost[i] + Math.min(cost[i - 1], cost[i - 2]);
        }

        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/min-cost-climbing-stairs/description/
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution