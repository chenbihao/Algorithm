package tree;

import linked.LeetCode_109_Solution;
import linked.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author: chenbihao
 * @create: 2021/9/16
 * @Description:
 * @History:
 */
public class LeetCode_104_MaximumDepthOfBinaryTreeTest {

    @Test
    public void test() {

        /**
         * 给定二叉树 [3,9,20,null,null,15,7]，
         *
         *     3
         *    / \
         *   9  20
         *     /  \
         *    15   7
         *
         * 返回它的最大深度  3 。
         */
        TreeNode root = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(17)));
        assertEquals(3,new LeetCode_104_Solution().maxDepth(root));

    }


}
