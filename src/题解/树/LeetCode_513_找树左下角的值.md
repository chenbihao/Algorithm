## LeetCode_513_找树左下角的值

https://leetcode-cn.com/problems/find-bottom-left-tree-value/

## 题目描述 ( 中等 )

```
给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。

假设二叉树中至少有一个节点。

示例 1:

输入: root = [2,1,3]
输出: 1


示例 2:

输入: [1,2,3,4,null,5,6,null,null,7]
输出: 7
 

提示:

二叉树的节点个数的范围是 [1,104]
-231 <= Node.val <= 231 - 1 
```

## 思路

- DFS （深度优先，递归返回最深最左）
- BFS （广度优先，迭代返回最深最左）

## 关键点


## 代码

Java Code:

```java
public class LeetCode_513_Solution {
    public int findBottomLeftValue(TreeNode root) {

        // 这里用BFS
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        int leftVal = 0;

        while (!queue.isEmpty()) {
            leftVal = queue.peek().val;
            int size = queue.size();
            while (size > 0) {
                size--;
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return leftVal;
    }
}
```


**复杂度分析**

- 时间复杂度：O(n)
- 空间复杂度：O(n)


