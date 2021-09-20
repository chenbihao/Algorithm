package linked;

import com.sun.source.tree.ReturnTree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author: chenbihao
 * @create: 2021/9/20
 * @Description:
 * @History:
 */
public class LeetCode_142_Solution {

    /**
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
     * 说明：不允许修改给定的链表。
     */
    public ListNode detectCycle(ListNode head) {

        if (head == null) {
            return null;
        }

        HashSet<ListNode> set = new HashSet<>();
        ListNode flag = head;

        while (flag.next != null) {
            set.add(flag);
            flag = flag.next;
            if (set.contains(flag)) {
                return flag;
            }
        }
        return null;
    }

    /**
     * 双链表
     *
     * @param head
     * @return
     */
    public ListNode detectCycleV2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;

        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            }else{
                return null;
            }
            if(fast==slow){
                ListNode ptr=head;
                while (ptr != slow) {
                    slow = slow.next;
                    ptr=ptr.next;
                }
                return ptr;
            }
        }
        return null;
    }


}

