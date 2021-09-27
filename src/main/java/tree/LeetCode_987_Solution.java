package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: chenbihao
 * @create: 2021/9/16
 * @Description:
 * @History:
 */
public class LeetCode_987_Solution {

    // 写错了 误解了题意，忘记考虑层序也要排序
    // 层序相同的再考虑值序!

//    /**
//     * 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
//     */
//    public List<List<Integer>> verticalTraversal(TreeNode root) {
//        ListNode left = verticalTraversal(new ListNode(root.val), root);
//        return getList(left);
//    }
//
//    private ListNode verticalTraversal(ListNode listNode, TreeNode root) {
//        ListNode left = null;
//        if (root == null) {
//            return left;
//        }
//        left = listNode;
//        if (root.left != null) {
//            if (listNode.prev == null) {
//                listNode.prev = new ListNode(root.left.val);
//                listNode.prev.next = listNode;
//            } else {
//                listNode.prev.add(root.left.val);
//            }
//            left = verticalTraversal(listNode.prev,root.left);
//        }
//        if (root.right != null) {
//            if (listNode.next == null) {
//                listNode.next = new ListNode(root.right.val);
//                listNode.next.prev = listNode;
//            } else {
//                listNode.next.add(root.right.val);
//            }
//            verticalTraversal(listNode.next,root.right);
//        }
//        return left;
//    }
//
//    private List<List<Integer>> getList(ListNode node){
//        List<List<Integer>> result = new ArrayList();
//        while (node != null) {
//            result.add( node.val);
//            node = node.next;
//        }
//        return result;
//    }
//
//    class ListNode {
//        List<Integer> val = new ArrayList<>();
//        ListNode prev;
//        ListNode next;
//        public ListNode(int i) {
//            this.val.add(i);
//        }
//        public void add(int i) {
//            this.val.add(i);
//        }
//    }


    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes = new ArrayList<int[]>();
        dfs(root, 0, 0, nodes);
        Collections.sort(nodes, new Comparator<int[]>() {
            public int compare(int[] tuple1, int[] tuple2) {
                if (tuple1[0] != tuple2[0]) {
                    return tuple1[0] - tuple2[0];
                } else if (tuple1[1] != tuple2[1]) {
                    return tuple1[1] - tuple2[1];
                } else {
                    return tuple1[2] - tuple2[2];
                }
            }
        });
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int size = 0;
        int lastcol = Integer.MIN_VALUE;
        for (int[] tuple : nodes) {
            int col = tuple[0], row = tuple[1], value = tuple[2];
            if (col != lastcol) {
                lastcol = col;
                ans.add(new ArrayList<Integer>());
                size++;
            }
            ans.get(size - 1).add(value);
        }
        return ans;
    }

    public void dfs(TreeNode node, int row, int col, List<int[]> nodes) {
        if (node == null) {
            return;
        }
        nodes.add(new int[]{col, row, node.val});
        dfs(node.left, row + 1, col - 1, nodes);
        dfs(node.right, row + 1, col + 1, nodes);
    }
}

