package _674;

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int len = 1;
        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                len++;
                if (len > maxLen) {
                    maxLen = len;
                }
            } else {
                len = 1;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findLengthOfLCIS(new int[] {1, 3, 5, 4, 7}));
        System.out.println(solution.findLengthOfLCIS(new int[] {2, 2, 2, 2}));
    }
}
