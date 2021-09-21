
## LeetCode_146_LRU缓存机制

https://leetcode-cn.com/problems/lru-cache/

## 题目描述 ( 中等 )

```
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
实现 LRUCache 类：

LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 

进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？

示例：

输入
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
输出
[null, null, null, 1, null, -1, null, -1, 3, 4]

解释
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // 缓存是 {1=1}
lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
lRUCache.get(1);    // 返回 1
lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
lRUCache.get(2);    // 返回 -1 (未找到)
lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
lRUCache.get(1);    // 返回 -1 (未找到)
lRUCache.get(3);    // 返回 3
lRUCache.get(4);    // 返回 4
 

提示：

1 <= capacity <= 3000
0 <= key <= 10000
0 <= value <= 105
最多调用 2 * 105 次 get 和 put
```

## 思路



## 关键点

双向链表 + hashMap

## 代码

Java Code:

```java
public class LeetCode_146_LRUCache {

    class DoubleLinkedListNode {
        int key, value;
        DoubleLinkedListNode prev, next;
        public DoubleLinkedListNode() {}
        public DoubleLinkedListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DoubleLinkedListNode> cache = new HashMap<>();
    int capacity, size = 0;
    DoubleLinkedListNode head, tail;

    public LeetCode_146_LRUCache(int capacity) {
        this.capacity = capacity;
        // 假头假尾
        head = new DoubleLinkedListNode();
        tail = new DoubleLinkedListNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // 不存在返回 -1
        DoubleLinkedListNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 存在则把它调到前面
        moveToHead(node);
        return node.value;
    }
    public void put(int key, int value) {
        DoubleLinkedListNode node = cache.get(key);
        if (node == null) {
            DoubleLinkedListNode newNode = new DoubleLinkedListNode(key, value);
            // 插入到头
            addToHead(newNode);
            cache.put(key, newNode);
            size++;
            // 如果插入后长度超过限制，则删除尾
            if (size > capacity) {
                DoubleLinkedListNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            // 更新值并移动到头
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DoubleLinkedListNode node) {
        node.prev = head;
        node.next = head.next;
        // 涉及到头尾的有点绕，具体是在操作假头假尾
        head.next.prev = node;
        head.next = node;
    }
    private void removeNode(DoubleLinkedListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void moveToHead(DoubleLinkedListNode node) {
        removeNode(node);
        addToHead(node);
    }
    private DoubleLinkedListNode removeTail() {
        // 操作假尾
        DoubleLinkedListNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
```


**复杂度分析**

- 时间复杂度：O(1)
- 空间复杂度：O(N)



