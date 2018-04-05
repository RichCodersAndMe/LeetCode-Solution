## Description

A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

**Example 1:**

```
Input:
left = 1, right = 22
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
```

**Note:**

The boundaries of each input argument are 1 <= left <= right <= 10000.

## 思路

算出所给范围内的符合要求（自身能被所有位数上的数字所整除，例如128能被1、2、8整除，且自身不能含有0）的数字。范围为1-10000，范围较小可先打表。

### 打表（Java）

```Java
int sum = 0;
for (int i = left; i < right; i++) {
    int num = i;
    int div;
    while (num != 0) {
        div = num % 10;
        if (div == 0) {
            break;
        }
        if ((i % div) != 0) {
            break;
        }
        num /= 10;
    }
    if (num == 0) {
        System.out.println(i);
        sum++;
    }
}
```

### JavaScript
```JavaScript
var selfDividingNumbers = function(left, right) {
  var result = []
  for (var i = left; i <= right; i++ ) {
    if (i < 10) {
      result.push(i)
    } else {
      if (/0/.test(i.toString())) {
        i = i + 1
      }
      for (var j = 0; j < i.toString().length; j++) {
        if (i % Number(i.toString().split('')[j]) !== 0) {
          break
        }
        if (i % Number(i.toString().split('')[j]) === 0 && j === i.toString().length - 1) {
          console.log(i);
          result.push(i)
        }
      }
    }
  }
  return result
};
```
