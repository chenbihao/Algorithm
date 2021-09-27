package tree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: chenbihao
 * @create: 2021/9/16
 * @Description:
 * @History:
 */
public class LeetCode_987_Test {

    @Test
    public void test() {

        /**
         * 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
         *
         * 对位于  (row, col)  的每个结点而言，其左右子结点分别位于  (row + 1, col - 1)  和  (row + 1, col + 1) 。树的根结点位于 (0, 0) 。
         *
         * 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。
         *
         * 返回二叉树的 垂序遍历 序列。
         */


        /**
         * 输入：root = [3,9,20,null,null,15,7]
         * 输出：[[9],[3,15],[20],[7]]
         */
        TreeNode root = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        List<List<Integer>> lists = new LeetCode_987_Solution().verticalTraversal(root);
        List<Integer> L11 = lists.get(0);
        List<Integer> L12 = lists.get(1);
        List<Integer> L13 = lists.get(2);
        List<Integer> L14 = lists.get(3);
        assertEquals(1, L11.size());assertEquals(9, L11.get(0));
        assertEquals(2, L12.size());assertEquals(3, L12.get(0));assertEquals(15, L12.get(1));
        assertEquals(1, L13.size());assertEquals(20,L13.get(0));
        assertEquals(1, L14.size());assertEquals(7, L14.get(0));


        /**
         * 输入：root = [1,2,3,4,5,6,7]
         * 输出：[[4],[2],[1,5,6],[3],[7]]
         */
        TreeNode root2 = new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3,new TreeNode(6),new TreeNode(7)));
        List<List<Integer>> lists2 = new LeetCode_987_Solution().verticalTraversal(root2);
        List<Integer> L21 = lists2.get(0);
        List<Integer> L22 = lists2.get(1);
        List<Integer> L23 = lists2.get(2);
        List<Integer> L24 = lists2.get(3);
        List<Integer> L25 = lists2.get(4);
        assertEquals(1, L21.size());assertEquals(4, L21.get(0));
        assertEquals(1, L22.size());assertEquals(2, L22.get(0));
        assertEquals(3, L23.size());assertEquals(1, L23.get(0));assertEquals(5,L23.get(1));assertEquals(6,L23.get(2));
        assertEquals(1, L24.size());assertEquals(3, L24.get(0));
        assertEquals(1, L25.size());assertEquals(7, L25.get(0));


        /**
         * 输入：root = [1,2,3,4,6,5,7]
         * 输出：[[4],[2],[1,5,6],[3],[7]]
         */
        TreeNode root3 = new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(6)),new TreeNode(3,new TreeNode(5),new TreeNode(7)));
        List<List<Integer>> lists3 = new LeetCode_987_Solution().verticalTraversal(root3);
        List<Integer> L31 = lists3.get(0);
        List<Integer> L32 = lists3.get(1);
        List<Integer> L33 = lists3.get(2);
        List<Integer> L34 = lists3.get(3);
        List<Integer> L35 = lists3.get(4);
        assertEquals(1, L31.size());assertEquals(4, L31.get(0));
        assertEquals(1, L32.size());assertEquals(2, L32.get(0));
        assertEquals(3, L33.size());assertEquals(1, L33.get(0));assertEquals(5,L33.get(1));assertEquals(6,L33.get(2));
        assertEquals(1, L34.size());assertEquals(3, L34.get(0));
        assertEquals(1, L35.size());assertEquals(7, L35.get(0));







    }


}
