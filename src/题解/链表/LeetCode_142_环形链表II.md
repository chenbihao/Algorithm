
## LeetCode_142_环形链表II

https://leetcode-cn.com/problems/linked-list-cycle-ii/

## 题目描述 ( 中等 )

```
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。

说明：不允许修改给定的链表。

进阶：

你是否可以使用 O(1) 空间解决此题？

示例 1：
输入：head = [3,2,0,-4], pos = 1
输出：返回索引为 1 的链表节点
解释：链表中有一个环，其尾部连接到第二个节点。

示例 2：
输入：head = [1,2], pos = 0
输出：返回索引为 0 的链表节点
解释：链表中有一个环，其尾部连接到第一个节点。

示例 3：
输入：head = [1], pos = -1
输出：返回 null
解释：链表中没有环。

提示：
链表中节点的数目范围在范围 [0, 104] 内
-105 <= Node.val <= 105
pos 的值为 -1 或者链表中的一个有效索引
```

## 思路

- 哈希set
- 双指针

双指针的思路是：
```
先来看下完全环形的链表：

       1 → 2 → 3
       ↑       ↓
       5   ←   4
 
慢指针每次走一步，快指针每次走2步，那么他们下次会在起点时相交

那如果我们遇到的是像题目这样前面还有一小段（1 → 2 → ），这里把这一小段称为段A，

环形链表：

1 → 2 → 3 → 4 → 5
        ↑       ↓
        7   ←   6
        
可以看做：

       3 → 4 → 5
       ↑       ↓
       7(2) ←  6(1)

他们也是会在起点时相交，这里的起点是6，所以如果链表有环的话，他们一定会在环中相遇
所以我们只要再走a段的长度，就能从相交点走到入口点

```


## 关键点

双指针

## 代码

Java Code:

``` java

public ListNode detectCycleV2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;

        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            }else{
                return null;
            }
            if(fast==slow){
                ListNode ptr=head;
                while (ptr != slow) {
                    slow = slow.next;
                    ptr=ptr.next;
                }
                return ptr;
            }
        }
        return null;
    }

```


**复杂度分析**

- 时间复杂度：O(N)
- 空间复杂度：O(1)


