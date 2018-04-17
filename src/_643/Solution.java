package _643;

public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int ans = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            if (ans < sum) {
                ans = sum;
            }
        }

        return (double) ans / k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMaxAverage(new int[] {1, 12, -5, -6, 50, 3}, 4));
    }
}
