
## LeetCode_100_相同的树

https://leetcode-cn.com/problems/same-tree/

## 题目描述 ( 简单 )

```
给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。


示例 1：
输入：p = [1,2,3], q = [1,2,3]
输出：true

示例 2：
输入：p = [1,2], q = [1,null,2]
输出：false

示例 3：
输入：p = [1,2,1], q = [1,1,2]
输出：false
 

提示：

两棵树上的节点数目都在范围 [0, 100] 内
-104 <= Node.val <= 104

```

## 思路

很简单，遍历一遍即可

- DFS （深度优先，占树高空间）（遍历同时比较，不能变成数组再去对比）
- BFS （广度优先，占额外空间）
- 前中后有2序相等 （任意2序相等证明2树相等，相当于进行2次DFS遍历存数组再对比）

## 关键点

DFS、BFS

## 代码

Java Code:

```java
public class LeetCode_100_Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
```


**复杂度分析**

- 时间复杂度：O(n)
- 空间复杂度：O(h)


