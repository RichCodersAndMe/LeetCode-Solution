/**
 * @param {string} s
 * @return {number}
 */
var countBinarySubstrings = function(s) {
    var ans = 0, i, m, n, length = s.length - 1;

    for (i = 0; i < length; i++) {
        if (s[i] === s[i+1]) continue;
        ans++;
        m = i - 1;
        n = i + 2;
        while(m >= 0 && n <= length) {
            if (s[m] !== s[i] || s[n] !== s[i+1]) break;
            m--;
            n++;
            ans++;
        }
    }

    return ans;
};

/**
 * @param {string} s
 * @return {number}
 */
var countBinarySubstrings = function(s) {
    var ans = 0, i, length = s.length, group = [1], prev = s[0];

    for (i = 1; i < length; i++) {
        if (s[i] === prev) {
            group[group.length - 1]++;
        } else {
            group.push(1);
            prev = s[i];
        }
    }
    for (i = 1; i < group.length; i++) ans += Math.min(group[i-1], group[i]);

    return ans;
};

/**
 * @param {string} s
 * @return {number}
 */
var countBinarySubstrings = function(s) {
    var ans = 0, i, length = s.length, prev = 0, cur = 1, prevStr = s[0];

    for (i = 1; i < length; i++) {
        if (s[i] === prevStr) {
            cur++;
        } else {
            prevStr = s[i];
            ans += Math.min(prev, cur);
            prev = cur;
            cur = 1;
        }
    }
    ans += Math.min(prev, cur);

    return ans;
};
