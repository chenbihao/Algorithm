package tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author: chenbihao
 * @create: 2021/9/16
 * @Description:
 * @History:
 */
public class LeetCode_297_SerializeAndDeserializeBinaryTreeTest {

    @Test
    public void test() {

        /**
         * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
         */

        /**
         * 输入：root = [1,2,3,null,null,4,5]
         * 输出：[1,2,3,null,null,4,5]
         */
        TreeNode node1 = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        String serialize1 = new LeetCode_297_Codec().serialize(node1);
        TreeNode deserialize1 = new LeetCode_297_Codec().deserialize(serialize1);
        assertTrue(new LeetCode_100_Solution().isSameTree(node1, deserialize1));

        /**
         * 输入：root = []
         * 输出：[]
         */
        TreeNode node2 = null;
        String serialize2 = new LeetCode_297_Codec().serialize(node2);
        TreeNode deserialize2 = new LeetCode_297_Codec().deserialize(serialize2);
        assertTrue(new LeetCode_100_Solution().isSameTree(node2, deserialize2));

        /**
         * 输入：root = [1]
         * 输出：[1]
         */
        TreeNode node3 = new TreeNode(1);
        String serialize3 = new LeetCode_297_Codec().serialize(node3);
        TreeNode deserialize3 = new LeetCode_297_Codec().deserialize(serialize3);
        assertTrue(new LeetCode_100_Solution().isSameTree(node3, deserialize3));

        /**
         * 输入：root = [1,2]
         * 输出：[1,2]
         */
        TreeNode node4 = new TreeNode(1);
        String serialize4 = new LeetCode_297_Codec().serialize(node4);
        TreeNode deserialize4 = new LeetCode_297_Codec().deserialize(serialize4);
        assertTrue(new LeetCode_100_Solution().isSameTree(node4, deserialize4));

    }


}
