package array_stack_queue;

import java.util.Stack;

/**
 * @author: chenbihao
 * @create: 2021/9/14
 * @Description:
 * @History:
 */
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
        return stackIn.empty()&& stackOut.empty();
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
