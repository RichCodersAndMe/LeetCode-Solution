/**
 * @param {number[]} nums
 * @return {number}
 */
var dominantIndex = function(nums) {
    var m1 = 0, m2 = 0, i, length = nums.length;

    for(i = 0; i < length; i++) {
        if (m1 < nums[i]) {
            m2 = m1;
            m1 = nums[i];
        } else if (m2 < nums[i]) {
            m2 = nums[i];
        }
    }
    if (m1 >= 2 * m2) return nums.indexOf(m1);

    return -1;    
};
