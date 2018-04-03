/**
 * @param {string} moves
 * @return {boolean}
 */
var judgeCircle = function(moves) {
    var length = moves.length, x = 0, y = 0;

    for (i = 0; i < length; i++) {
        switch(moves[i]) {
            case 'L':
                x--;
                break;
            case 'R':
                x++;
                break;
            case 'U':
                y++;
                break;
            case 'D':
                y--;
                break;
        }
    }

    return x === 0 && y === 0;
};

/**
 * @param {string} moves
 * @return {boolean}
 */
var judgeCircle = function(moves) {
    var countL, countR, countU, countD;

    countL = moves.match(/L/g);
    countL = countL === null ? 0 : countL.length;
    countR = moves.match(/R/g);
    countR = countR === null ? 0 : countR.length;
    countU = moves.match(/U/g);
    countU = countU === null ? 0 : countU.length;
    countD = moves.match(/D/g);
    countD = countD === null ? 0 : countD.length;
    
    return countL === countR && countD === countU;
};
