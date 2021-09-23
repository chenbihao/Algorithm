package tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author: chenbihao
 * @create: 2021/9/16
 * @Description:
 * @History:
 */
public class LeetCode_100_SameTreeTest {

    @Test
    public void test() {

        /**
         * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
         * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
         */
        TreeNode node1 = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(17)));
        TreeNode node2 = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(17)));
        assertEquals(true,new LeetCode_100_Solution().isSameTree(node1,node2));

        /**
         * 输入：p = [1,2,3], q = [1,2,3]
         * 输出：true
         */
        TreeNode node11 = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        TreeNode node12 = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        assertEquals(true,new LeetCode_100_Solution().isSameTree(node11,node12));

        /**
         * 输入：p = [1,2], q = [1,null,2]
         * 输出：false
         */
        TreeNode node21 = new TreeNode(1,new TreeNode(2),null);
        TreeNode node22 = new TreeNode(1,null,new TreeNode(3));
        assertEquals(false,new LeetCode_100_Solution().isSameTree(node21,node22));

        /**
         * 输入：p = [1,2,1], q = [1,1,2]
         * 输出：false
         */
        TreeNode node31 = new TreeNode(1,new TreeNode(2),new TreeNode(1));
        TreeNode node32 = new TreeNode(1,new TreeNode(1),new TreeNode(2));
        assertEquals(false,new LeetCode_100_Solution().isSameTree(node31,node32));

    }


}
