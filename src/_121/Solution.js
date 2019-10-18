/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
  let finalProfit = 0
  for(var i = 0; i < prices.length; i++) {
      for(var j = 0; j < i; j++) {
          let profit = prices[i] - prices[j]
          if(profit > finalProfit) {
              finalProfit = profit
          }
      }
  }
  return finalProfit
};