
## LeetCode_768_最多能完成排序的块II

https://leetcode-cn.com/problems/max-chunks-to-make-sorted-ii/

## 题目描述 ( 困难 )

```
这个问题和“最多能完成排序的块”相似，但给定数组中的元素可以重复，输入数组最大长度为2000，其中的元素最大为10**8。

arr是一个可能包含重复元素的整数数组，我们将这个数组分割成几个“块”，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。

我们最多能将数组分成多少块？

示例 1:

输入: arr = [5,4,3,2,1]
输出: 1
解释:
将数组分成2块或者更多块，都无法得到所需的结果。
例如，分成 [5, 4], [3, 2, 1] 的结果是 [4, 5, 1, 2, 3]，这不是有序的数组。 
示例 2:

输入: arr = [2,1,3,4,4]
输出: 4
解释:
我们可以把它分成两块，例如 [2, 1], [3, 4, 4]。
然而，分成 [2, 1], [3], [4], [4] 可以得到最多的块数。 
注意:

arr的长度在[1, 2000]之间。
arr[i]的大小在[0, 10**8]之间。
```

## 思路

栈、单调栈、队列

## 关键点

在纠结到底是`块内排序`还是`块的和`再排序，

结果是块内排序 & 原数组排序：

> 分割成几个“块” `分别进行排序`，使得连接的结果和按`升序排序后的原数组`相同。


可以用
- 滑动窗口
- 单调栈
- 计数排序
- ...

题解：
https://leetcode-cn.com/problems/max-chunks-to-make-sorted-ii/solution/zui-duo-neng-wan-cheng-pai-xu-de-kuai-ii-deng-jie-/
https://leetcode-solution.cn/solutionDetail?type=3&id=6&max_id=2


## 代码

Java Code:

``` java

public int maxChunksToSorted(int[] arr) {

// 这里使用滑动窗口的解法：当滑动窗口的和相等的话，则说明可以分块

int count=0;
int sum1=0,sum2=0;

int[] sortArr = Arrays.copyOf(arr, arr.length);
Arrays.sort(sortArr);

for (int i = 0; i < arr.length; i++) {

    sum1+=arr[i];
    sum2+=sortArr[i];

    if (sum1 ==sum2) {
        count ++;
        //sum1 = sum2 = 0; 
    }
}
return count;

```


**复杂度分析**

- 时间复杂度：O(NlogN)
- 空间复杂度：O(N)


