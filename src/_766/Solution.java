package _766;

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int h = matrix.length - 1;
        int w = matrix[0].length - 1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isToeplitzMatrix(new int[][]{{1, 2}, {2, 2}}));
        System.out.println(solution.isToeplitzMatrix(new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}}));
    }
}
