package _733;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }
        dfs(image, sr, sc, oldColor, newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if (image[sr][sc] == oldColor) {
            image[sr][sc] = newColor;
            if (sr > 0) dfs(image, sr - 1, sc, oldColor, newColor);
            if (sr + 1 < image.length) dfs(image, sr + 1, sc, oldColor, newColor);
            if (sc > 0) dfs(image, sr, sc - 1, oldColor, newColor);
            if (sc + 1 < image[sr].length) dfs(image, sr, sc + 1, oldColor, newColor);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] image = solution.floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2);
        for (int[] row : image) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
