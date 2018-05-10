package _747;

class Solution {
    public int dominantIndex(int[] nums) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        for (int num : nums) {
            if (num < max && max < num + num) {
                return -1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dominantIndex(new int[] {3, 6, 1, 0}));
        System.out.println(solution.dominantIndex(new int[] {1, 2, 3, 4}));
    }
}