package linked;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author: chenbihao
 * @create: 2021/9/20
 * @Description:
 * @History:
 */
public class LeetCode_142_LinkedListCycleIITest {

    @Test
    public void test() {

        /**
         * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
         * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
         * 说明：不允许修改给定的链表。
         *
         * 提示：
         * 链表中节点的数目范围在范围 [0, 104] 内
         * -105 <= Node.val <= 105
         * pos 的值为 -1 或者链表中的一个有效索引
         */

        /**
         * 示例 1：
         * 输入：head = [3,2,0,-4], pos = 1
         * 输出：返回索引为 1 的链表节点
         * 解释：链表中有一个环，其尾部连接到第二个节点。
         */
        ListNode tail = new ListNode(4);
        ListNode intersect = new ListNode(2, new ListNode(0, tail));
        tail.next = intersect;
        ListNode head = new ListNode(3, intersect);

        ListNode intersectionNode = new LeetCode_142_Solution().detectCycle(head);
        assertEquals(intersect, intersectionNode);

        /**
         * 示例 2：
         * 输入：head = [1,2], pos = 0
         * 输出：返回索引为 0 的链表节点
         * 解释：链表中有一个环，其尾部连接到第一个节点。
         */
        ListNode tail2 = new ListNode(2);
        ListNode intersect2 = new ListNode(1, tail2);
        tail2.next = intersect2;

        ListNode intersectionNode2 = new LeetCode_142_Solution().detectCycle(intersect2);
        assertEquals(intersect2, intersectionNode2);

        /**
         * 示例 3：
         * 输入：head = [1], pos = -1
         * 输出：返回 null
         * 解释：链表中没有环。
         */
        ListNode intersect3 = new ListNode(1);
        ListNode intersectionNode3 = new LeetCode_142_Solution().detectCycle(intersect3);
        assertEquals(null, intersectionNode3);

    }


    @Test
    public void testV2() {

        ListNode tail = new ListNode(4);
        ListNode intersect = new ListNode(2, new ListNode(0, tail));
        tail.next = intersect;
        ListNode head = new ListNode(3, intersect);
        ListNode intersectionNode = new LeetCode_142_Solution().detectCycleV2(head);
        assertEquals(intersect, intersectionNode);

        ListNode tail2 = new ListNode(2);
        ListNode intersect2 = new ListNode(1, tail2);
        tail2.next = intersect2;
        ListNode intersectionNode2 = new LeetCode_142_Solution().detectCycleV2(intersect2);
        assertEquals(intersect2, intersectionNode2);

        ListNode intersect3 = new ListNode(1);
        ListNode intersectionNode3 = new LeetCode_142_Solution().detectCycleV2(intersect3);
        assertEquals(null, intersectionNode3);

    }

}
