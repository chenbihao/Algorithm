package linked;

/**
 * @author: chenbihao
 * @create: 2021/9/16
 * @Description:
 * @History:
 */
public class LeetCode_24_Solution {

    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * <p>
     * 示例 1：
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     * <p>
     * 示例 2：
     * 输入：head = []
     * 输出：[]
     * <p>
     * 示例 3：
     * 输入：head = [1]
     * 输出：[1]
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode flag = head;
        // 如果第二个有值，把返回的头定在第二个
        ListNode result = head.next != null ? head.next : head;

        ListNode temp2, temp3;
        // 判断单数和双数是否为空，不为空则调换顺序
        while (flag != null && flag.next != null) {

            // 存第2、3位指针
            temp2 = flag.next;
            temp3 = temp2.next;

            // 判断3、4是否为空 空的话1链到3（因为无法支撑下一轮操作） 否则链到4（继续下一轮）
            if (temp3 == null || temp3.next == null) {
                flag.next = flag.next.next;
            } else {
                flag.next = flag.next.next.next;
            }

            // 第2位的指针指向第1位
            temp2.next = flag;
            // 当前遍历的指针指向第3位
            flag = temp3;
        }
        return result;
    }

}

