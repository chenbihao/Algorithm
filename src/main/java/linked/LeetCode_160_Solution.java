package linked;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author: chenbihao
 * @create: 2021/9/16
 * @Description:
 * @History:
 */
public class LeetCode_160_Solution {

    /**
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode result = null;
        // 初始化2个栈 压进去
        Stack<ListNode> stackA = new Stack(), stackB = new Stack();

        while (headA != null) {
            stackA.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            stackB.push(headB);
            headB = headB.next;
        }

        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            ListNode a = stackA.pop();
            if (a == stackB.pop()) {
                result = a;
            } else {
                return result;
            }
        }
        return result;
    }


    public ListNode getIntersectionNodeV2(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }


    public ListNode getIntersectionNodeV3(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;

        // 遍历一次
        while (p1 != p2) {
            // 如果不等于空，就继续；如果等于空，就换到另一条链上继续遍历
            p1 = p1 == null ? headA : p1.next;
            p2 = p2 == null ? headB : p2.next;
        }
        return p1;
    }


}

