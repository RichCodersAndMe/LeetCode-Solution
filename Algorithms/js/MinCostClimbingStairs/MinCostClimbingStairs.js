/**
 * @param {number[]} cost
 * @return {number}
 */
var minCostClimbingStairs = function(cost) {
    var i, length = cost.length, nLength = length - 2, dis = [], tmp1, tmp2;

    for(i = 0; i < length; i++) {
        dis[i] = -1;
    }
    dis[0] = cost[0];
    dis[1] = cost[1];
    for(i = 0; i < nLength; i++) {
        tmp1 = dis[i] + cost[i + 1];
        tmp2 = dis[i] + cost[i + 2];
        if (dis[i + 1] === -1 || tmp1 < dis[i + 1]) dis[i + 1] = tmp1;
        if (dis[i + 2] === -1 || tmp2 < dis[i + 2]) dis[i + 2] = tmp2;
    }

    return dis[length - 2] < dis[length - 1] ? dis[length - 2] : dis[length - 1];
};

/**
 * @param {number[]} cost
 * @return {number}
 */
var minCostClimbingStairs = function(cost) {
    var f1 = 0, f2 = 0, f0 = 0, i, length = cost.length;

    for(i = 0; i < length; i++) {
        f0 = Math.min(f1 + cost[i], f2 + cost[i]);
        f2 = f1;
        f1 = f0;
    }

    return Math.min(f1, f2);
};
