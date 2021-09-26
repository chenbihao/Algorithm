package tree;

import java.util.*;

/**
 * @author: chenbihao
 * @create: 2021/9/26
 * @Description:
 * @History:
 */
public class LeetCode_297_Codec {

    /**
     * 序列
     */
    public String serialize(TreeNode root) {
        return serialize(root, "");
    }

    public String serialize(TreeNode node, String str) {
        if (node == null) {
            str += "null,";
        } else {
            str += node.val + ",";
            str = serialize(node.left, str);
            str = serialize(node.right, str);
        }
        return str;
    }

    /**
     * 反序列化
     */
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        LinkedList<String> dataList = new LinkedList(Arrays.asList(dataArray));
        return deserialize(dataList);
    }

    private TreeNode deserialize(LinkedList<String> dataList) {
        if ("null".equals(dataList.get(0))) {
            dataList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(0);
        root.left = deserialize(dataList);
        root.right = deserialize(dataList);
        return root;
    }
}

