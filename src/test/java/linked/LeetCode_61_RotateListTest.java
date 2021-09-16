package linked;

import junitSupport.IntArrayConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author: chenbihao
 * @create: 2021/9/16
 * @Description:
 * @History:
 */
public class LeetCode_61_RotateListTest {

    @Test
    public void test() {

        /**
         * 输入：head = [1,2,3,4,5], k = 2
         * 输出：[4,5,1,2,3]
         */
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode result = new LeetCode_61_Solution().rotateRight(head, 2);

        assertEquals(4,result.val);
        assertEquals(5,result.next.val);
        assertEquals(1,result.next.next.val);
        assertEquals(2,result.next.next.next.val);
        assertEquals(3,result.next.next.next.next.val);
        assertEquals(null,result.next.next.next.next.next);


        /**
         * 输入：head = [0,1,2], k = 4
         * 输出：[2,0,1]
         */

        ListNode head2 = new ListNode(0, new ListNode(1, new ListNode(2)));

        ListNode result2 = new LeetCode_61_Solution().rotateRight(head2, 4);

        assertEquals(2,result2.val);
        assertEquals(0,result2.next.val);
        assertEquals(1,result2.next.next.val);
        assertEquals(null,result2.next.next.next);

    }


}
