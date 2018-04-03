/**
 * @param {number[]} nums
 * @return {boolean}
 */
var checkPossibility = function(nums) {
    var length = nums.length, i = 0, j = length - 1;

    function scan(arr) {
        var length = arr.length - 1, i;

        for(i = 0; i < length; i++) {
            if (arr[i] > arr[i+1]) return false;
        }

        return true;
    }

    function bruteForce(arr) {
        let tmpArr, i, length = arr.length;

        for (i = 0; i < length; i++) {
            tmpArr = arr.slice();
            tmpArr.splice(i, 1);
            if (scan(tmpArr)) return true;
        }

        return false;
    }

    while(i + 2 < length && nums[i] <= nums[i+1] && nums[i+1] <= nums[i+2]) i++;
    while(j - 2 >= 0 && nums[j-2] <= nums[j-1] && nums[j-1] <= nums[j]) j--;
    if (j - i + 1 <= 2) return true;
    if (j - i + 1 >= 5) return false;

    return bruteForce(nums.slice(i, j + 1));
};

/**
 * @param {number[]} nums
 * @return {boolean}
 */
var checkPossibility = function(nums) {
    var p = null, i, length = nums.length - 1;

    for(i = 0; i < length; i++) {
        if (nums[i] > nums[i + 1]) {
            if (p !== null) return false;
            p = i;
        }
    }

    return p === null || p === 0 || p === length - 1 || nums[p - 1] <= nums[p + 1] || nums[p] <= nums[p + 2];
};
