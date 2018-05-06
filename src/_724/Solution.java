package _724;

class Solution {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int leftSum = 0;
        int rightSum = 0;

        for (int i = nums.length - 1; i > 0; i--) {
            rightSum += nums[i];
        }

        if (rightSum == 0) {
            return 0;
        }

        for (int i = 1; i < nums.length; i++) {
            leftSum += nums[i - 1];
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(solution.pivotIndex(new int[]{1, 2, 3}));
        System.out.println(solution.pivotIndex(new int[]{0}));
    }
}
