/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
    let list = [...new Set([...nums])]
    for(let i = 0; i < list.length; i++) {
        let majorityNum = 0
        for(let j = 0; j < nums.length; j++) {
            if(list[i] === nums[j]) {
                majorityNum++
                if(majorityNum > nums.length / 2) {
                    return list[i]
                }
            }
        }
    }
};