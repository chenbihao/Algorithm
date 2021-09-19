
## LeetCode_160_相交链表

https://leetcode-cn.com/problems/intersection-of-two-linked-lists/

## 题目描述 ( 简单 )

```
给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。

输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Intersected at '8'

输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
输出：Intersected at '2'

输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
输出：null

提示：

listA 中节点数目为 m
listB 中节点数目为 n
0 <= m, n <= 3 * 104
1 <= Node.val <= 105
0 <= skipA <= m
0 <= skipB <= n
如果 listA 和 listB 没有交点，intersectVal 为 0
如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1]
 
进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？
```

## 思路

很多种解法：
- 栈：最开始用的是2个栈，全部入栈，然后再从栈顶去对比
- 统一起点：统计下2个链表的长度，让长的先走，走到同一起跑线后并排走，如有一致则返回
- 哈希Set：只需遍历一个链存进Set，然后遍历另一个链表时对比即可
- 双指针：因为双指针的长度总合是相等的（（链A+B）乘2 == （链B+A）乘2），所以双指针最终会走向同一个终点（null），如果中间遇到相交的提前返回即可

## 关键点

双指针

## 代码

Java Code:

``` java
public ListNode getIntersectionNodeV3(ListNode headA, ListNode headB) {
    ListNode p1 = headA, p2 = headB;

    // 遍历一次
    while (p1 != p2) {
        // 如果不等于空，就继续；如果等于空，就换到另一条链上继续遍历
        p1 = p1 == null ? headA : p1.next;
        p2 = p2 == null ? headB : p2.next;
    }
    return p1;
}
```


**复杂度分析**

- 时间复杂度：O(n)
- 空间复杂度：O(1)


