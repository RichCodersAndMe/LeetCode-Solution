/**
 * @param {number[]} nums
 * @return {number}
 */
var findShortestSubArray = function(nums) {
    var prev = -1, degree = 0, count, i, j, length = nums.length, arr = [], ansNums = [], ans = 50000, left, right;

    for(i = 0; i < length; i++) arr[i] = nums[i];
    arr.sort();
    for(i = 0; i < length; i++) {
        if (prev !== arr[i]) {
            prev = arr[i];
            count = 1;
        } else {
            count++;
        }
        if (count > degree) {
            degree = count;
            ansNums = [arr[i]];
        } else if (count === degree) {
            ansNums.push(arr[i]);
        }
    }
    for(i = 0; i < ansNums.length; i++) {
        for(j = 0; j < length; j++) {
            if (nums[j] === ansNums[i]) {
                left = j;
                break;
            }
        }
        for(j = length - 1; j >=0; j--) {
            if (nums[j] === ansNums[i]) {
                right = j;
                break;
            }
        }
        if (ans > right - left + 1) ans = right - left + 1;
    }

    return ans;
};

/**
 * @param {number[]} nums
 * @return {number}
 */
var findShortestSubArray = function(nums) {
    var left = new Map(), right = new Map(), count = new Map(),
        i, length = nums.length, numCount, arr = [],
        key, degree = 0, prev = -1, ans = 50000;

    for (i = 0; i < length; i++) {
        if (left.get(nums[i]) === undefined) left.set(nums[i], i);
        right.set(nums[i], i);
        numCount = count.get(nums[i]) || 0;
        count.set(nums[i], numCount + 1);
    }
    for (key of count.keys()) {
        if (count.get(key) > degree) {
            degree = count.get(key);
            arr = [key];
        } else if (count.get(key) === degree) {
            arr.push(key);
        }
    }
    for (i = 0; i < arr.length; i++) {
        if (ans > right.get(arr[i]) - left.get(arr[i]) + 1) ans = right.get(arr[i]) - left.get(arr[i]) + 1;
    }

    return ans;
};
