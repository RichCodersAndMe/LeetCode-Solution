/**
 * 
 * 第一版
 * 
 * @param {number} L
 * @param {number} R
 * @return {number}
 */
// var countPrimeSetBits = function(L, R) {
//     var set = 0, count = 0, i, tmp, j, check = true;
    
//     for(i = L; i <= R; i++) {
//         set = 0;
//         check = true;
//         tmp = i;
//         while (tmp > 0) {
//             if (tmp % 2 === 1) {
//                 set++;
//             }
//             tmp = Math.floor(tmp / 2);
//         }
//         for(j = 2; j < set; j++) {
//             if (set % j === 0) {
//                 check = false;
//                 break;
//             }
//         }
//         if (check && set !== 1) count++;
//     }

//     return count;
// };

/**
 * 
 * 由于取值范围 10^6 < 2^20, 所以可以枚举出可能的素数
 * 
 * @param {number} L
 * @param {number} R
 * @return {number}
 */
var countPrimeSetBits = function(L, R) {
    var set = 0, count = 0, i, tmp, j;
    
    for(i = L; i <= R; i++) {
        set = 0;
        check = true;
        tmp = i;
        while (tmp > 0) {
            if (tmp % 2 === 1) {
                set++;
            }
            tmp = Math.floor(tmp / 2);
        }
        if (set === 2 || set === 3 || set === 5 || set === 7 || set === 11 || set === 13 || set === 17 || set === 19) count++;
    }

    return count;
};
