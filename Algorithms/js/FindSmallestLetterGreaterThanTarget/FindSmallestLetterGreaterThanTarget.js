/**
 * @param {character[]} letters
 * @param {character} target
 * @return {character}
 */
var nextGreatestLetter = function(letters, target) {
    var i, length = letters.length, mini = 0, dis = 26, nDis;

    for(i = 0; i < length; i++) {
        nDis = (letters[i].charCodeAt() - target.charCodeAt() + 26) % 27;
        if (nDis < dis) {
            dis = nDis;
            mini = i;    
        }
    }

    return letters[mini];
};

/**
 * @param {character[]} letters
 * @param {character} target
 * @return {character}
 */
var nextGreatestLetter = function(letters, target) {
    var i, length = letters.length;

    for(i = 0; i < length; i++) {
        if (letters[i] > target) return letters[i];
    }
    
    return letters[0];
};
