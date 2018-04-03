/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    var i, max, m, k, v;
    m = new Map();
    max = nums.length;
    
    for(i = 0; i < max; i++) {
        k = target - nums[i];
        v = m.get(k);
        if (m.has(k) && v !== i) return [v, i];
        m.set(nums[i], i);
    }
};