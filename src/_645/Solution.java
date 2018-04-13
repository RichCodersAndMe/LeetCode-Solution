package _645;

public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] pos = new int[nums.length + 1];
        int[] ans = new int[2];

        // Find error number.
        for (int i : nums) {
            if ((++pos[i]) > 1) {
                ans[0] = i;
            }
        }

        // Find Missing number.
        for (int i = 0; i < pos.length; i++) {
            if (pos[i] == 0) {
                ans[1] = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ans = solution.findErrorNums(new int[] {1, 2, 2, 4});
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
