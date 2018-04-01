package _1;
// remove the line of `package xxx.xxx.xxx.xxx;` when you commit it

import java.util.Arrays;

/**
 * @author relish
 * @since 2018/04/01
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2, 7, 11, 15},9)));
    }
}

