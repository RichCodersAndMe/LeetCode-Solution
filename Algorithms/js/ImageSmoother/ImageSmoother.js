/**
 * @param {number[][]} M
 * @return {number[][]}
 */
var imageSmoother = function(M) {
    var ans = [], r = M.length, c = M[0].length, i, j, x1, x2, y1, y2;

    function calc(arr, x1, x2, y1, y2) {
        var sum = 0, count = 0, i, j;

        for (i = x1; i < x2; i++) {
            for (j = y1; j < y2; j++) {
                count++;
                sum += arr[i][j];
            }
        }
        
        return Math.floor(sum / count);
    }

    for(i = 0; i < r; i++) ans[i] = [];
    for (i = 0; i < r; i++) {
        for (j = 0; j < c; j++) {
            if (i === 0) x1 = 0;
            else x1 = i - 1;
            if (i === r - 1) x2 = r;
            else x2 = i + 2;
            if (j === 0) y1 = 0;
            else y1 = j - 1;
            if (j === c - 1) y2 = c;
            else y2 = j + 2;
            ans[i][j] = calc(M, x1, x2, y1, y2);
        }
    }

    return ans;
};

/**
 * @param {number[][]} M
 * @return {number[][]}
 */
var imageSmoother = function(M) {
    var ans = [], r = M.length, c = M[0].length, i, j, m, n, count, sum;

    for(i = 0; i < r; i++) ans[i] = [];
    for (i = 0; i < r; i++) {
        for (j = 0; j < c; j++) {
            count = 0;
            sum = 0;
            for (m = i - 1; m < i + 2; m++) {
                for (n = j - 1; n < j + 2; n++) {
                    if (m >= 0 && m < r && n >= 0 && n < c) {
                        count++;
                        sum += M[m][n];
                    }
                }
            }
            ans[i][j] = Math.floor(sum / count);
        }
    }

    return ans;
};
