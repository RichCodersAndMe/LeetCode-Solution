/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
    nums1.splice(m)
    nums2.splice(n)
    nums1.push(...nums2)
    for(var i = 0; i < nums1.length - 1; i++) {
        for(var j = 0; j < nums1.length - 1 - i; j++) {
            if(nums1[j] > nums1[j+1]) {
                var x = nums1[j]
                nums1[j] = nums1[j+1]
                nums1[j+1] = x
            }
        }
    }
};