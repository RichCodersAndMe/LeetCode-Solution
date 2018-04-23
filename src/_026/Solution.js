var removeDuplicates = function(nums) {
    for (var i = 1;i < nums.length; i++) {
        for (var j = 0; j < i; j++){
            if (nums[i] === nums[j]) {
                nums.splice(i, 1)
				i = i - 1
            }
        }
    }
    return nums.length
};
