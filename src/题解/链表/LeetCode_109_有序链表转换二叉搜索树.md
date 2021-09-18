
## LeetCode_109_有序链表转换二叉搜索树

https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/

## 题目描述 ( 中等 )

```
给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定的有序链表： [-10, -3, 0, 5, 9],

一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5

```

## 思路

递归：
- 快慢指针
缓存：
- 

## 关键点

递归

## 代码

Java Code:

``` java
public TreeNode sortedListToBST(ListNode head) {
    return dfs(head, null);
}

private TreeNode dfs(ListNode head, ListNode tail) {
    if (head == tail) {
        return null;
    }
    // 寻找中点
    ListNode fast = head, slow = head;
    while (fast != tail && fast.next != tail) {
        fast = fast.next.next;
        slow = slow.next;
    }
    // 慢的就是中点
    TreeNode treeNode = new TreeNode(slow.val);
    // 分别拿左右边的值递归下去
    treeNode.left = dfs(head, slow);
    treeNode.right = dfs(slow.next, tail);
    return treeNode;
}
```


**复杂度分析**

- 时间复杂度：O(nlogn)
- 空间复杂度：O(logn)


