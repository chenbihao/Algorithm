
## LeetCode_24_两两交换链表中的节点

https://leetcode-cn.com/problems/swap-nodes-in-pairs/

## 题目描述 ( 中等 )

```
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1：
输入：head = [1,2,3,4]
输出：[2,1,4,3]

示例 2：
输入：head = []
输出：[]

示例 3：
输入：head = [1]
输出：[1]
 

提示：
链表中节点的数目在范围 [0, 100] 内
0 <= Node.val <= 100
```

## 思路

解法：
- 递归
- 迭代（本次解法）


2个值互换看起来挺简单的

主要要有临时指针来存放，然后改一下单数位和双数位的next就好了

比如：(下标表示next指针指向的位置) 
- 原始链表： **1**<sub>2</sub>  2<sub>3</sub>   3<sub>4</sub>  4<sub>null</sub>
- 下标改成：   1<sub>4</sub>  **2**<sub>1</sub>  3<sub>null</sub>  4<sub>3</sub>   
  按照顺序：  **2**<sub>1</sub>  1<sub>4</sub> 4<sub>3</sub> 3<sub>null</sub>

这里有个容易绕进去的点在于:第一位的next不是指向第三位，而是第四位

因为如果第三四位有值的话，三四位也是需要交换的,最终指向的是第四位

所以代码流程为： 
- 第一位指向第四位（如果第三四位有空则指向第三位）
- 第二位指向第一位
- 操作指针指向第三位，继续下一轮操作


## 关键点

链表的基础操作

## 代码

Java Code:

``` java

public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode flag = head;
        // 如果第二个有值，把返回的头定在第二个
        ListNode result = head.next != null ? head.next : head;

        ListNode temp2, temp3;
        // 判断单数和双数是否为空，不为空则调换顺序
        while (flag != null && flag.next != null) {

            // 存第2、3位指针
            temp2 = flag.next;
            temp3 = temp2.next;

            // 判断3、4是否为空 空的话1链到3（因为无法支撑下一轮操作） 否则链到4（继续下一轮）
            if (temp3 == null || temp3.next == null) {
                flag.next = flag.next.next;
            } else {
                flag.next = flag.next.next.next;
            }

            // 第2位的指针指向第1位
            temp2.next = flag;
            // 当前遍历的指针指向第3位
            flag = temp3;
        }
        return result;
    }

```


**复杂度分析**

- 时间复杂度：O(n)
- 空间复杂度：O(1)


