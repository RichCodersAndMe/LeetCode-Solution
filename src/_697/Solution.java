package _697;

import java.util.HashMap;

class Solution {
    public int findShortestSubArray(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }

        HashMap<Integer, Integer> firstPositions = new HashMap<>(max);
        HashMap<Integer, Integer> degrees = new HashMap<>(max);
        int maxDegree = 1;
        int minLen = 1;

        int degree;
        int len;
        for (int i = 0; i < nums.length; i++) {
            firstPositions.putIfAbsent(nums[i], i);
            degree = degrees.getOrDefault(nums[i], 0);
            degrees.put(nums[i], ++degree);
            if (degree < maxDegree) {
                continue;
            }

            len = i - firstPositions.get(nums[i]) + 1;
            if (degree > maxDegree) {
                maxDegree = degree;
                minLen = len;
            } else if (degree == maxDegree && minLen > len) {
                minLen = len;
            }
        }

        return minLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findShortestSubArray(new int[] {1, 2, 2, 3, 1, 4, 2}));
    }
}