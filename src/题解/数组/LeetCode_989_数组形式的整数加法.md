
## 题目地址(989. 数组形式的整数加法)

https://leetcode-cn.com/problems/add-to-array-form-of-integer/

## 题目描述

```
对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。

给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。

 

示例 1：

输入：A = [1,2,0,0], K = 34
输出：[1,2,3,4]
解释：1200 + 34 = 1234


示例 2：

输入：A = [2,7,4], K = 181
输出：[4,5,5]
解释：274 + 181 = 455


示例 3：

输入：A = [2,1,5], K = 806
输出：[1,0,2,1]
解释：215 + 806 = 1021


示例 4：

输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
输出：[1,0,0,0,0,0,0,0,0,0,0]
解释：9999999999 + 1 = 10000000000


 

提示：

1 <= A.length <= 10000
0 <= A[i] <= 9
0 <= K <= 10000
如果 A.length > 1，那么 A[0] != 0
```

## 思路

硬刚出来的，明天看看别人的解答

## 关键点

-

## 代码

- 语言支持：Java

Java Code:

```java

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        // 先转int[] 再去加   进位字段
        String kStr = String.valueOf(k);
        int[] kArray = getIntArray(kStr);

        List<Integer> result;

        // 计算并取进位
        if (num.length >= kArray.length) {
            result = calculate(num, kArray);
        } else {
            result = calculate(kArray, num);
        }
        return result;
    }

private List<Integer> calculate(int[] longer, int[] shorter) {
        int carry = 0;
        for (int i = 0; i < longer.length; i++) {
            int longerLen = longer.length - i - 1;
            int shorterLen = shorter.length - i - 1;

            if (shorterLen >= 0) {
                int i1 = shorter[shorterLen] + longer[longerLen] + carry;
                longer[longerLen] = i1 % 10;
                carry = i1 / 10;
            } else {
                // 当k比num位数少的时候，还得计算完进位的情况
                if (carry != 0) {
                    int i1 = longer[longerLen] + carry;
                    longer[longerLen] = i1 % 10;
                    carry = i1 / 10;
                }
            }
        }

        // 判断最后有没有进位，有的话补上
        List<Integer> result = Arrays.stream(longer).boxed().collect(Collectors.toList());
        if (carry != 0) {
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(carry);
            integers.addAll(result);
            result = integers;
        }
        return result;
    }
    
    private int[] getIntArray(String str) {
        int[] ints = new int[str.length()];
        for (int i = 0; i < ints.length; i++) {
            Character ch = str.charAt(i);
            ints[i] = Integer.parseInt(ch.toString());
        }
        return ints;
    }

}

```


**复杂度分析**

令 n 为数组长度。

- 时间复杂度：$O(n)$
- 空间复杂度：$O(n)$


