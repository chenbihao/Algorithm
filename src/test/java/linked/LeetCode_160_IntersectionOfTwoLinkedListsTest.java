package linked;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author: chenbihao
 * @create: 2021/9/16
 * @Description:
 * @History:
 */
public class LeetCode_160_IntersectionOfTwoLinkedListsTest {

    @Test
    public void test() {

        /**
         * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
         */
        /**
         * intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
         * 输出：Intersected at '8'
         * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
         * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
         * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
         */
        ListNode intersect = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode headA = new ListNode(4, new ListNode(1,intersect));
        ListNode headB = new ListNode(5, new ListNode(0, new ListNode(1, intersect)));

        ListNode intersectionNode = new LeetCode_160_Solution().getIntersectionNode(headA, headB);
        Assertions.assertEquals(8, intersectionNode.val);

        /**
         * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
         * 输出：Intersected at '2'
         */
        ListNode intersect2 = new ListNode(2, new ListNode(4));
        ListNode head2A = new ListNode(0, new ListNode(9, new ListNode(1, intersect2)));
        ListNode head2B = new ListNode(3,intersect2);

        ListNode intersectionNode2 = new LeetCode_160_Solution().getIntersectionNode(head2A, head2B);
        Assertions.assertEquals(2, intersectionNode2.val);

        /**
         * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
         * 输出：null
         */
        ListNode head3A = new ListNode(2, new ListNode(4, new ListNode(6)));
        ListNode head3B = new ListNode(1, new ListNode(5));

        ListNode intersectionNode3 = new LeetCode_160_Solution().getIntersectionNode(head3A, head3B);
        Assertions.assertEquals(null, intersectionNode3);

    }



    @Test
    public void testV2() {
        ListNode intersect = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode headA = new ListNode(4, new ListNode(1,intersect));
        ListNode headB = new ListNode(5, new ListNode(0, new ListNode(1, intersect)));
        ListNode intersectionNode = new LeetCode_160_Solution().getIntersectionNodeV2(headA, headB);
        Assertions.assertEquals(8, intersectionNode.val);

        ListNode intersect2 = new ListNode(2, new ListNode(4));
        ListNode head2A = new ListNode(0, new ListNode(9, new ListNode(1, intersect2)));
        ListNode head2B = new ListNode(3,intersect2);
        ListNode intersectionNode2 = new LeetCode_160_Solution().getIntersectionNodeV2(head2A, head2B);
        Assertions.assertEquals(2, intersectionNode2.val);

        ListNode head3A = new ListNode(2, new ListNode(4, new ListNode(6)));
        ListNode head3B = new ListNode(1, new ListNode(5));
        ListNode intersectionNode3 = new LeetCode_160_Solution().getIntersectionNodeV2(head3A, head3B);
        Assertions.assertEquals(null, intersectionNode3);
    }


    @Test
    public void testV3() {
        ListNode intersect = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode headA = new ListNode(4, new ListNode(1,intersect));
        ListNode headB = new ListNode(5, new ListNode(0, new ListNode(1, intersect)));
        ListNode intersectionNode = new LeetCode_160_Solution().getIntersectionNodeV3(headA, headB);
        Assertions.assertEquals(8, intersectionNode.val);

        ListNode intersect2 = new ListNode(2, new ListNode(4));
        ListNode head2A = new ListNode(0, new ListNode(9, new ListNode(1, intersect2)));
        ListNode head2B = new ListNode(3,intersect2);
        ListNode intersectionNode2 = new LeetCode_160_Solution().getIntersectionNodeV3(head2A, head2B);
        Assertions.assertEquals(2, intersectionNode2.val);

        ListNode head3A = new ListNode(2, new ListNode(4, new ListNode(6)));
        ListNode head3B = new ListNode(1, new ListNode(5));
        ListNode intersectionNode3 = new LeetCode_160_Solution().getIntersectionNodeV3(head3A, head3B);
        Assertions.assertEquals(null, intersectionNode3);
    }

}
