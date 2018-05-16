package _746;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] = cost[i] + Math.min(cost[i - 1], cost[i - 2]);
        }

        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCostClimbingStairs(new int[] {10, 15, 20}));
        System.out.println(solution.minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}