
## LeetCode_1381_设计一个支持增量操作的栈

https://leetcode-cn.com/problems/design-a-stack-with-increment-operation/

## 题目描述

``` java
请你设计一个支持下述操作的栈。

实现自定义栈类 CustomStack ：

CustomStack(int maxSize)：用 maxSize 初始化对象，maxSize 是栈中最多能容纳的元素数量，栈在增长到 maxSize 之后则不支持 push 操作。
void push(int x)：如果栈还未增长到 maxSize ，就将 x 添加到栈顶。
int pop()：弹出栈顶元素，并返回栈顶的值，或栈为空时返回 -1 。
void inc(int k, int val)：栈底的 k 个元素的值都增加 val 。如果栈中元素总数小于 k ，则栈中的所有元素都增加 val 。
 

示例：

输入：
["CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"]
[[3],[1],[2],[],[2],[3],[4],[5,100],[2,100],[],[],[],[]]
输出：
[null,null,null,2,null,null,null,null,null,103,202,201,-1]
解释：
CustomStack customStack = new CustomStack(3); // 栈是空的 []
customStack.push(1);                          // 栈变为 [1]
customStack.push(2);                          // 栈变为 [1, 2]
customStack.pop();                            // 返回 2 --> 返回栈顶值 2，栈变为 [1]
customStack.push(2);                          // 栈变为 [1, 2]
customStack.push(3);                          // 栈变为 [1, 2, 3]
customStack.push(4);                          // 栈仍然是 [1, 2, 3]，不能添加其他元素使栈大小变为 4
customStack.increment(5, 100);                // 栈变为 [101, 102, 103]
customStack.increment(2, 100);                // 栈变为 [201, 202, 103]
customStack.pop();                            // 返回 103 --> 返回栈顶值 103，栈变为 [201, 202]
customStack.pop();                            // 返回 202 --> 返回栈顶值 202，栈变为 [201]
customStack.pop();                            // 返回 201 --> 返回栈顶值 201，栈变为 []
customStack.pop();                            // 返回 -1 --> 栈为空，返回 -1
 

提示：

1 <= maxSize <= 1000
1 <= x <= 1000
1 <= k <= 1000
0 <= val <= 100
每种方法 increment，push 以及 pop 分别最多调用 1000 次
```

## 思路
最开始写测试的时候以为数组的值也要每一步一致，导致走了点弯路

其实题目只要 pop 和 push，并没有获取整个数组的方法

看题解的时候发现还有优化的做法，可以使inc操作的时间复杂度优化为 O(1):

* 增加一个增量操作的数组
* 调用 inc 时，只需要简单的赋值，复杂度是 O(1) ，v1版的是for循环，复杂度是 O(k)
* 调用 pop 时，只需要获取顶部的增量值+原栈值；并且把增量值往下合并即可

因为这里是栈的结构，只需操作栈顶，所以可以不用考虑获取中间值的状况，所以可以使用这种方法来优化 inc 方法的复杂度

## 关键点

栈 、前缀和

## 代码

Java Code:

```java

package array_stack_queue;

/**
 * @author: chenbihao
 * @create: 2021/9/10
 * @Description:
 * @History:
 */
public class LeetCode_1381_CustomStack {

    int top;
    int[] stack;

    public LeetCode_1381_CustomStack(int maxSize) {
        top = -1;
        stack = new int[maxSize];
    }

    public void push(int x) {
        if (top != stack.length - 1) {
            stack[++top] = x;
        }
    }

    public int pop() {
        if (top == -1) {
            return -1;
        }
        return stack[top--];
    }

    public void increment(int k, int val) {
        k = Math.min(k, top + 1);
        for (int i = 0; i < k; i++) {
            stack[i] += val;
        }
    }
}

class LeetCode_1381_CustomStack_v2 {

    int top;
    int[] stack, add;

    public LeetCode_1381_CustomStack_v2(int maxSize) {
        top = -1;
        stack = new int[maxSize];
        add = new int[maxSize];
    }

    public void push(int x) {
        if (top != stack.length - 1) {
            stack[++top] = x;
        }
    }

    public int pop() {
        if (top == -1) {
            return -1;
        }
        int ret = stack[top] + add[top];
        if (top != 0) {
            add[top - 1] += add[top];
        }
        add[top--] = 0;
        return ret;
    }

    public void increment(int k, int val) {
        k = Math.min(k - 1, top);
        if (k >= 0) {
            add[k] += val;
        }
    }
}


```


**复杂度分析**

v1版：
- 时间复杂度：  
  - push 操作和 pop 操作： O(1) 
  - inc 操作： O(k)
- 空间复杂度： O(maxSize)

v2版：
- 时间复杂度： O(1)
- 空间复杂度： O(maxSize)
