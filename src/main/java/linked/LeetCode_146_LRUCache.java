package linked;

import com.sun.source.tree.NewArrayTree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: chenbihao
 * @create: 2021/9/21
 * @Description:
 * @History:
 */
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

