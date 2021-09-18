package linked;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author: chenbihao
 * @create: 2021/9/16
 * @Description:
 * @History:
 */
public class LeetCode_24_SwapNodesInPairsTest {

    @Test
    public void test() {

        /**
         * 输入：head = [1,2,3,4]
         * 输出：[2,1,4,3]
         */
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        ListNode result = new LeetCode_24_Solution().swapPairs(head);
        assertEquals(2,result.val);
        assertEquals(1,result.next.val);
        assertEquals(4,result.next.next.val);
        assertEquals(3,result.next.next.next.val);
        assertEquals(null,result.next.next.next.next);

        /**
         * 输入：head = []
         * 输出：[]
         */

        ListNode head2 = null;
        ListNode result2 = new LeetCode_24_Solution().swapPairs(head2);
        assertEquals(null,result2);


        /**
         * 输入：head = [1]
         * 输出：[1]
         */
        ListNode head3 = new ListNode(1);

        ListNode result3= new LeetCode_24_Solution().swapPairs(head3);
        assertEquals(1,result3.val);
        assertEquals(null,result3.next);


    }


}
