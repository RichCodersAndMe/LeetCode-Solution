package _661;

class Solution {
    public int[][] imageSmoother(int[][] M) {
        int[][] result = new int[M.length][M[0].length];

        int sum;
        int count;
        int xLen = M.length;
        int yLen = M[0].length;
        int nx, ny;

        for (int x = 0; x < M.length; x++) {
            for (int y = 0; y < M[x].length; y++) {
                sum = 0;
                count = 0;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        nx = x+i;
                        ny = y+j;
                        if (nx >= 0 && nx < xLen && ny >= 0 && ny < yLen) {
                            sum += M[nx][ny];
                            count++;
                        }
                    }
                }

                result[x][y] = sum / count;
            }
        }

        return result;
    }
}