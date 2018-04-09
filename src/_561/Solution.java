package _561;

public class Solution {

    public int arrayPairSum(int[] nums) {
        // 使用桶排序
        // 创建map数组，map数组下标对应nums数组内的数字，存的是对应数字的数量
        int[] map = new int[20001];
        for (int num : nums) {
            map[num + 10000]++;
        }

        // 遍历，取出奇数位的数并相加即可
        int ans = 0;
        boolean odd = false;
        for (int i = 0; i < map.length; i++) {
            while (map[i] != 0) {
                if (odd = !odd) {
                    ans += i - 10000;
                }
                map[i]--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.arrayPairSum(new int[]{1, 4, 3, 2}));
    }
}
