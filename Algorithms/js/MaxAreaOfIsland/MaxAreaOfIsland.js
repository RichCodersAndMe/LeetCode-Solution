/**
 * @param {number[][]} grid
 * @return {number}
 */
var maxAreaOfIsland = function(grid) {
    var ans = 0, island, i, j, rMax, cMax, stack = [], tmp;

    rMax = grid.length;
    if (rMax) cMax = grid[0].length;

    for (i = 0; i < rMax; i++) {
        for (j = 0; j < cMax; j++) {
            if (grid[i][j] !== 0) stack.push([i, j]);
            island = 0;
            while(stack.length) {
                tmp = stack.pop();
                if (grid[tmp[0]][tmp[1]] === 0) continue; 
                island++;
                grid[tmp[0]][tmp[1]] = 0;
                if (tmp[0] > 0 && grid[tmp[0] - 1][tmp[1]] !== 0) stack.push([tmp[0] - 1, tmp[1]]);
                if (tmp[0] < rMax - 1 && grid[tmp[0] + 1][tmp[1]] !== 0) stack.push([tmp[0] + 1, tmp[1]]);
                if (tmp[1] > 0 && grid[tmp[0]][tmp[1] - 1] !== 0) stack.push([tmp[0], tmp[1] - 1]);
                if (tmp[1] < cMax - 1 && grid[tmp[0]][tmp[1] + 1] !== 0) stack.push([tmp[0], tmp[1] + 1]);
            }
            if (island > ans) ans = island;
        }
    }

    return ans;
};
