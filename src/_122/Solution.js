/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    let profit = 0;
    for (let i = 0; i < prices.length - 1; i++) {
        const possibleProfit = prices[i + 1] - prices[i];
        profit = Math.max(profit + possibleProfit, profit);
    }
    return profit;
};