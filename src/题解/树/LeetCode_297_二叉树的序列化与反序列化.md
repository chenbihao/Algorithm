## LeetCode_297_二叉树的序列化与反序列化

https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/

## 题目描述 ( 困难 )

```
序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。

请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。


示例 1：

输入：root = [1,2,3,null,null,4,5]
输出：[1,2,3,null,null,4,5]

示例 2：

输入：root = []
输出：[]

示例 3：

输入：root = [1]
输出：[1]

示例 4：

输入：root = [1,2]
输出：[1,2]
 
提示：

树中结点数在范围 [0, 104] 内
-1000 <= Node.val <= 1000
```

## 思路

完全二叉树

如果按照完全二叉树来给节点编号的话

那么已知一个节点的编号是 i，
那么其左子节点就是 2 * i，
右子节点就是 2 * i + 1，
父节点就是 i / 2。


## 关键点

- DFS
- BFS

## 代码

Java Code:

```java
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
```


**复杂度分析**

- 时间复杂度：O(n)
- 空间复杂度：O(n)


