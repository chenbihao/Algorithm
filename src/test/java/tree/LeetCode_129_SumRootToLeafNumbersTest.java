package tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author: chenbihao
 * @create: 2021/9/16
 * @Description:
 * @History:
 */
public class LeetCode_129_SumRootToLeafNumbersTest {

    @Test
    public void test() {

        /**
         * 计算从根节点到叶节点生成的 所有数字之和 。
         */

        /**
         * 输入：root = [1,2,3]
         * 输出：25
         * 从根到叶子节点路径 1->2 代表数字 12
         * 从根到叶子节点路径 1->3 代表数字 13
         * 因此，数字总和 = 12 + 13 = 25
         */
        TreeNode root = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        assertEquals(25,new LeetCode_129_Solution().sumNumbers(root));


        /**
         * 输入：root = [4,9,0,5,1]
         * 输出：1026
         * 解释：
         * 从根到叶子节点路径 4->9->5 代表数字 495
         * 从根到叶子节点路径 4->9->1 代表数字 491
         * 从根到叶子节点路径 4->0 代表数字 40
         * 因此，数字总和 = 495 + 491 + 40 = 1026
         */
        TreeNode root2 = new TreeNode(4,new TreeNode(9,new TreeNode(5),new TreeNode(1)),new TreeNode(0));
        assertEquals(1026,new LeetCode_129_Solution().sumNumbers(root2));

    }


}
