/**
 * @param {number[][]} image
 * @param {number} sr
 * @param {number} sc
 * @param {number} newColor
 * @return {number[][]}
 */
var floodFill = function(image, sr, sc, newColor) {
    var stack1 = [], stack2 = [], pixel, rMax, cMax, color;

    rMax = image.length;
    if (rMax) cMax = image[0].length;
    stack1.push([sr, sc]);
    color = image[sr][sc];
    while(stack1.length) {
        pixel = stack1.pop();
        stack2.push(pixel);
        if (pixel[0] - 1 >= 0 && image[pixel[0] - 1][pixel[1]] === color) stack1.push([pixel[0] - 1, pixel[1]]);
        if (pixel[0] + 1 < rMax && image[pixel[0] + 1][pixel[1]] === color) stack1.push([pixel[0] + 1, pixel[1]]);
        if (pixel[1] - 1 >= 0 && image[pixel[0]][pixel[1] - 1] === color) stack1.push([pixel[0], pixel[1] - 1]);
        if (pixel[1] + 1 < cMax && image[pixel[0]][pixel[1] + 1] === color) stack1.push([pixel[0], pixel[1] + 1]);
        image[pixel[0]][pixel[1]] = -1;
    }
    while(stack2.length) {
        pixel = stack2.pop();
        image[pixel[0]][pixel[1]] = newColor;
    };

    return image;
};

/**
 * @param {number[][]} image
 * @param {number} sr
 * @param {number} sc
 * @param {number} newColor
 * @return {number[][]}
 */
var floodFill = function(image, sr, sc, newColor) {
    var color = image[sr][sc], rMax = image.length, cMax = image[0].length;

    function dfs(image, r, c, color, newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) dfs(image, r-1, c, color, newColor);
            if (c >= 1) dfs(image, r, c-1, color, newColor);
            if (r+1 < rMax) dfs(image, r+1, c, color, newColor);
            if (c+1 < cMax) dfs(image, r, c+1, color, newColor);
        }
    }

    if (color != newColor) dfs(image, sr, sc, color, newColor);

    return image;
};

/**
 * @param {number[][]} image
 * @param {number} sr
 * @param {number} sc
 * @param {number} newColor
 * @return {number[][]}
 */
var floodFill = function(image, sr, sc, newColor) {
    var stack = [], pixel, rMax = image.length, cMax = image[0].length, color;

    stack.push([sr, sc]);
    color = image[sr][sc];
    while(stack.length) {
        pixel = stack.pop();
        if (image[pixel[0]][pixel[1]] === newColor) continue;
        if (pixel[0] - 1 >= 0 && image[pixel[0] - 1][pixel[1]] === color) stack.push([pixel[0] - 1, pixel[1]]);
        if (pixel[0] + 1 < rMax && image[pixel[0] + 1][pixel[1]] === color) stack.push([pixel[0] + 1, pixel[1]]);
        if (pixel[1] - 1 >= 0 && image[pixel[0]][pixel[1] - 1] === color) stack.push([pixel[0], pixel[1] - 1]);
        if (pixel[1] + 1 < cMax && image[pixel[0]][pixel[1] + 1] === color) stack.push([pixel[0], pixel[1] + 1]);
        image[pixel[0]][pixel[1]] = newColor;
    }

    return image;
};
