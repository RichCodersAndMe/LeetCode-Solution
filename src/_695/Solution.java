package _695;

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int area;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    area = area(grid, i, j);
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }

    private int area(int[][] grid, int x, int y) {
        if (grid[x][y] != 1) {
            return 0;
        }

        grid[x][y] = 2;

        int sum = 1;
        if (x - 1 >= 0) {
            sum += area(grid, x - 1, y);
        }
        if (x + 1 < grid.length) {
            sum += area(grid, x + 1, y);
        }
        if (y - 1 >= 0) {
            sum += area(grid, x, y - 1);
        }
        if (y + 1 < grid[0].length) {
            sum += area(grid, x, y + 1);
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grids = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 1, 1}};
        System.out.println(solution.maxAreaOfIsland(grids));
    }
}