/**
 * @param {number[][]} matrix
 * @return {boolean}
 */
var isToeplitzMatrix = function(matrix) {
    var x, y, i, j;
    x = matrix.length;
    y = x ? matrix[0].length : 0;
    for (i = 1; i < x; i++) {
        for (j = 1; j < y; j++) {
            if (matrix[i][j] !== matrix[i - 1][j - 1]) return false;
        }
    }
    return true;
};
