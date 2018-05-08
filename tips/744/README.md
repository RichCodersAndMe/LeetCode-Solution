[Find Smallest Letter Greater Than Target][title]

## Description

Given a list of sorted characters `letters` containing only lowercase letters, and given a target letter `target`, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is `target = 'z'` and `letters = ['a', 'b']`, the answer is `'a'`.

**Examples:**

```
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"
```

**Note:**

1. `letters` has a length in range `[2, 10000]`.
2. `letters` consists of lowercase letters, and contains at least 2 unique letters.
3. `target` is a lowercase letter.

**Tags:** [Binary Search](https://leetcode.com/tag/binary-search/)

## 思路 1

给出一个已排序的小写字母的字符数组和一个字符，要求在此字符数组中找到最小的比此字符大的字符。若没有返回字符数组的第一个字符即可。

从头遍历数组，当发现比此字符大的，返回结果即可。

**Java:**

```java
public char nextGreatestLetter(char[] letters, char target) {
    int i = 0;
    while (i < letters.length) {
        if (letters[i] > target) {
            return letters[i];
        }
        i++;
    }
    return letters[0];
}
```

## 思路 2

此字符数组是排序过的，因此可以使用二分查找。

**Java:**

```java
public char nextGreatestLetter(char[] letters, char target) {
    if (letters[letters.length - 1] <= target) {
        return letters[0];
    }

    int left = 0;
    int right = letters.length;
    int mi;
    while (left < right) {
        mi = left + (right - left) / 2;
        if (letters[mi] <= target) {
            left = mi + 1;
        } else {
            right = mi;
        }
    }
    return letters[left];
}
```

## 结语

如果你同我们一样热爱数据结构、算法、LeetCode，可以关注我们 GitHub 上的 LeetCode 题解：[LeetCode-Solution][ls]

[title]: https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
[ls]: https://github.com/RichCodersAndMe/LeetCode-Solution