package _665;

class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums.length < 3) {
            return true;
        }

        int modifyCount = 0;

        if (nums[0] > nums[1]) {
            modifyCount++;
            nums[0] = nums[1];
        }

        for (int i = 1; i < nums.length && modifyCount < 2; i++) {
            if (nums[i] < nums[i-1]) {
                if (nums[i] > nums[i-2]) {
                    nums[i-1] = nums[i-2];
                } else {
                    nums[i] = nums[i-1];
                }
                modifyCount++;
            }
        }
        return modifyCount < 2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkPossibility(new int[]{4, 2, 3}));
        System.out.println(solution.checkPossibility(new int[]{4, 2, 1}));
        System.out.println(solution.checkPossibility(new int[]{2, 3, 3, 2, 4}));
        System.out.println(solution.checkPossibility(new int[]{-1, 4, 2, 3}));
    }
}
