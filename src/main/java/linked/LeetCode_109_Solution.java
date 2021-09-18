package linked;

/**
 * @author: chenbihao
 * @create: 2021/9/16
 * @Description:
 * @History:
 */
public class LeetCode_109_Solution {

    /**
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     * <p>
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[4,5,1,2,3]
     * <p>
     * 输入：head = [0,1,2], k = 4
     * 输出：[2,0,1]
     */
    public TreeNode sortedListToBST(ListNode head) {

        if (head == null) {
            return null;
        }
        return dfs(head, null);
    }

    private TreeNode dfs(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        // 寻找中点
        ListNode fast = head, slow = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 慢的就是中点
        TreeNode treeNode = new TreeNode(slow.val);
        // 分别拿左右边的值递归下去
        treeNode.left = dfs(head, slow);
        treeNode.right = dfs(slow.next, tail);
        return treeNode;
    }
}

