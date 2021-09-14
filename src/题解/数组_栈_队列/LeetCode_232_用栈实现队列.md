
## LeetCode_232_用栈实现队列

https://leetcode-cn.com/problems/implement-queue-using-stacks/

## 题目描述 ( 简单 )

```
请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：

实现 MyQueue 类：

void push(int x) 将元素 x 推到队列的末尾
int pop() 从队列的开头移除并返回元素
int peek() 返回队列开头的元素
boolean empty() 如果队列为空，返回 true ；否则，返回 false
 

说明：

你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 

进阶：

你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
 

示例：

输入：
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
输出：
[null, null, null, 1, 1, false]

解释：
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false
 

提示：

1 <= x <= 9
最多调用 100 次 push、pop、peek 和 empty
假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）

```

## 思路

栈、队列

## 关键点

由2个栈：后进先出（last in - first out， LIFO）

来实现队列：先进先出（first in - first out， FIFO）

可以利用反转

几种实现方法：
- 一个当队列栈（主栈），一个当临时栈
  - push：先把队列里的一个个取出放入到临时栈，然后把 push 的值放到队列最底部，最后把临时栈里的值取回到队列里，复杂度O(n)
  - pop、peek、isEmpty：针对队列栈调用即可，复杂度O(1)
- 一个当输入栈，一个当输出栈
  - push：直接压入输入栈中，复杂度O(1)
  - pop、peek：先判断输出栈是否为空，为空的话需要做一下反转操作（从输入栈取出到输出栈），然后直接对输出栈进行调用即可，摊还复杂度O(1)
  - isEmpty:判断2个栈是否都为空，复杂度O(1)

## 代码

Java Code:

``` java
public class LeetCode_232_MyQueue {

    Stack<Integer> stackIn, stackOut;

    public LeetCode_232_MyQueue() {
        stackIn = new Stack();
        stackOut = new Stack();
    }

    public void push(int x) {
        // 把 x 入栈
        stackIn.push(x);
    }

    public int pop() {
        stackReverse();
        return stackOut.pop();
    }

    public int peek() {
        stackReverse();
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.empty() && stackOut.empty();
    }

    /**
     * 要取的话，判断reverse是否为空，空的话先反转
     */
    private void stackReverse() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }

}
```



**复杂度分析**

- 时间复杂度：O(1)
- 空间复杂度：O(n)


