package tree;

import javax.sql.PooledConnection;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: chenbihao
 * @create: 2021/9/16
 * @Description:
 * @History:
 */
public class LeetCode_513_Solution {

    /**
     * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
     */
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

