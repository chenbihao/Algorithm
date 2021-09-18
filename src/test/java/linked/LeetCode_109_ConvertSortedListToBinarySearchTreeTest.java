package linked;

import org.junit.jupiter.api.Test;

/**
 * @author: chenbihao
 * @create: 2021/9/16
 * @Description:
 * @History:
 */
public class LeetCode_109_ConvertSortedListToBinarySearchTreeTest {

    @Test
    public void test() {

        /**
         * 输入：[-10, -3, 0, 5, 9]
         * 输出树：
         *       0
         *      / \
         *    -3   9
         *    /   /
         *  -10  5
         *
         * [0, -3, 9, -10, null, 5]
         */
        ListNode head = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))));


        TreeNode result = new LeetCode_109_Solution().sortedListToBST(head);








    }


}
