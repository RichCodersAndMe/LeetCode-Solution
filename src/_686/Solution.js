/**
 * @param {string} A
 * @param {string} B
 * @return {number}
 */
// var repeatedStringMatch = function(A, B) {
//     var ans = 0, lengthA = A.length, lengthB = B.length - 1, i, j, check;

//     for (i = 0; i < lengthA; i++) {
//         j = 0;
//         check = true;
//         if (A[i] !== B[j]) continue;
//         while(j < lengthB) {
//             j++;
//             if (A[(i + j) % lengthA] !== B[j]) {
//                 check = false;
//                 break;
//             }
//         }
//         if (check) {
//             ans = Math.ceil((i + j + 1) / lengthA);
//             break;
//         }
//     }

//     return ans === 0 ? -1 : ans;
// };

/**
 * @param {string} A
 * @param {string} B
 * @return {number}
 */
var repeatedStringMatch = function(A, B) {
    var length = B.length, i, q = 0, S = '';
    
    while(S.length < length) {
        S += A;
        q++;
    }
    if (S.indexOf(B) > -1) return q;
    S += A;
    if (S.indexOf(B) > -1) return q + 1;
    return -1;
};
