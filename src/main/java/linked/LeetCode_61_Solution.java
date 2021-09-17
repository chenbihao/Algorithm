package linked;

/**
 * @author: chenbihao
 * @create: 2021/9/16
 * @Description:
 * @History:
 */
public class LeetCode_61_Solution {

    /**
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     * <p>
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[4,5,1,2,3]
     * <p>
     * 输入：head = [0,1,2], k = 4
     * 输出：[2,0,1]
     */
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        int count = 1;
        ListNode flag = head;

        // 先遍历总长
        while (flag.next != null) {
            count++;
            flag = flag.next;
        }
        // 取余
        int mod = k % count;
        if (mod == 0) {
            return head;
        }

        // 单纯取余的话是向左移动，这里向右移所以减一下
        int needNext = count - mod;
        flag.next = head;
        flag=head;

        // 循环一下找到新尾，设置新尾的next为空
        for (int i = 1; i < needNext; i++) {
            flag = flag.next;
        }
        ListNode result = flag.next;
        flag.next = null;
        return result;
    }

}

