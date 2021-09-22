package tree;

import linked.ListNode;

import java.sql.Array;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: chenbihao
 * @create: 2021/9/16
 * @Description:
 * @History:
 */
public class LeetCode_104_Solution {

    /**
     * 给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     */
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

