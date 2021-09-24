package tree;

import com.sun.source.tree.IfTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: chenbihao
 * @create: 2021/9/16
 * @Description:
 * @History:
 */
public class LeetCode_129_Solution {

    private int sum=0;

    /**
     * 求根节点到叶节点数字之和
     */
    public int sumNumbers(TreeNode root) {
        getSum(root,0);
        return sum;
    }

    private void getSum(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        int levelSum = sum * 10 + root.val;

        // 如果为叶子节点 则添加进总和
        if(root.left==null && root.right == null){
            this.sum += levelSum;
        }else{
            getSum(root.left,levelSum);
            getSum(root.right,levelSum);
        }
    }


}

