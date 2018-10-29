var findMedianSortedArrays = function(nums1, nums2) {
    var l1 = nums1.length;
    var l2 = nums2.length;
    var i = 0, j = 0, k = 0;
    var midIndex = Math.ceil((l1+l2) / 2)
    var midNum1,midNum2,midNum
    if((l1+l2)%2 === 0) {
       while(k <= midIndex) {
            k++;
			if(i > l1 - 1) {
				midNum1  = nums2[midIndex-k +j]
				midNum2  =nums2[midIndex-k +j + 1]
				break;
			}
			if(j > l2 - 1) {
				midNum1  = nums2[midIndex-k +i]
				midNum2  =nums2[midIndex-k +i + 1]
				break;
			}
            if(nums1[i]>nums2[j]) {
                if(k === midIndex) {
                    midNum1 = nums2[j];
                } else if(k === (midIndex+1)){
					midNum2 = nums2[j];
				}
                j++;
            } else {
                if(k === midIndex) {
                    midNum1 = nums1[i];
                } else if(k === (midIndex+1)){
					midNum2 = nums1[i];
				}
                i++;
            }
        }
	midNum = (midNum1 + midNum2) / 2
    } else {
        while(k < midIndex) {
            k++;
            if(nums1[i]>nums2[j]) {
                j++;
                if(k === midIndex) {
                    midNum = nums2[j-1];
                }
            } else {
                i++;
                if(k === midIndex) {
                    midNum = nums1[i-1];
                }
            }
        }
    }
    return midNum
};
findMedianSortedArrays([1,2,4,6],[3,4])