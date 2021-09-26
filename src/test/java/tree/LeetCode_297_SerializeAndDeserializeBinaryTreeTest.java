package tree;

import org.junit.jupiter.api.Test;

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
        TreeNode node1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(17)));
        String serialize = new LeetCode_297_Codec().serialize(node1);
        TreeNode deserialize = new LeetCode_297_Codec().deserialize(serialize);

        /**
         * 输入：root = []
         * 输出：[]
         */


        /**
         * 输入：root = [1]
         * 输出：[1]
         */


        /**
         * 输入：root = [1,2]
         * 输出：[1,2]
         */

    }


}
