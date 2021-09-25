package tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author: chenbihao
 * @create: 2021/9/16
 * @Description:
 * @History:
 */
public class LeetCode_513_FindBottomLeftTreeValueTest {

    @Test
    public void test() {

        /**
         * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
         *
         * 假设二叉树中至少有一个节点。
         */

        /**
         * 输入: root = [2,1,3]
         * 输出: 1
         */
        TreeNode root = new TreeNode(2,new TreeNode(1),new TreeNode(3));
        assertEquals(1,new LeetCode_513_Solution().findBottomLeftValue(root));

        /**
         * 输入: [1,2,3,4,null,5,6,null,null,7]
         * 输出: 7
         */

        TreeNode root2 = new TreeNode(1,new TreeNode(2,new TreeNode(4),null),new TreeNode(3,new TreeNode(5,new TreeNode(7),null),new TreeNode(6)));

        assertEquals(7,new LeetCode_513_Solution().findBottomLeftValue(root2));

    }


}
