var plusOne = function(digits) {
	len  = digits.length - 1
    if(digits[len] < 9) {
        digits[len] = digits[len] + 1
    } else {
        while(len > 0 && digits[len] === 9) {
			digits[len] = 0
			len--
		}
		if(digits[len] === 9) {
			digits[len] = 0
			digits.unshift(1)
		} else {
			digits[len] = digits[len] + 1
		}
    }
	return digits
};