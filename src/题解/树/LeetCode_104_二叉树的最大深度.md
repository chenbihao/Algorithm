
## LeetCode_104_二叉树的最大深度

https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/

## 题目描述 ( 简单 )

```
给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。
```

## 思路

- 递归 DFS （深度优先，递归返回最深层数）
- 迭代 BFS （广度优先，迭代每一层并计数）

## 关键点

树的遍历

## 代码

Java Code:

```java
public class LeetCode_104_Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (queue.size() > 0) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}
```


**复杂度分析**

- 时间复杂度：O(n)
- 空间复杂度：O(n)


