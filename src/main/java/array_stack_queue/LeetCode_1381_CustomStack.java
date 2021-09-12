package array_stack_queue;

/**
 * @author: chenbihao
 * @create: 2021/9/12
 * @Description:
 * @History:
 */
public class LeetCode_1381_CustomStack {

    /**
     * 请你设计一个支持下述操作的栈。
     * <p>
     * 实现自定义栈类 CustomStack ：
     * <p>
     * CustomStack(int maxSize)：用 maxSize 初始化对象，maxSize 是栈中最多能容纳的元素数量，栈在增长到 maxSize 之后则不支持 push 操作。
     * void push(int x)：如果栈还未增长到 maxSize ，就将 x 添加到栈顶。
     * int pop()：弹出栈顶元素，并返回栈顶的值，或栈为空时返回 -1 。
     * void inc(int k, int val)：栈底的 k 个元素的值都增加 val 。如果栈中元素总数小于 k ，则栈中的所有元素都增加 val 。
     */


    int top;
    int[] stack;

    public LeetCode_1381_CustomStack(int maxSize) {
        top = -1;
        stack = new int[maxSize];
    }

    public void push(int x) {
        if (top != stack.length - 1) {
            stack[++top] = x;
        }
    }

    public int pop() {
        if (top == -1) {
            return -1;
        }
        return stack[top--];
    }

    public void increment(int k, int val) {
        k = Math.min(k, top + 1);
        for (int i = 0; i < k; i++) {
            stack[i] += val;
        }
    }

}


class LeetCode_1381_CustomStack_v2 {

    /**
     * 优化：使inc操作的时间复杂度优化为 O(1)
     *
     * 具体做法：增加一个增量操作的数组
     * 调用inc时，只需要简单的赋值，复杂度是 O(1) ，v1版的是for循环，复杂度是 O(k)
     * 调用pop时，只需要获取顶部的增量值+原栈值；并且把增量值往下合并即可
     *
     * 例如：
     * stack:[1,2,3]
     * add:[0,0,0]
     *
     * 调用inc(2,100) add:[0,0,0] ->  add:[0,100,0]
     * 调用inc(3,60)  add:[0,100,0] ->  add:[0,100,60]
     *
     * 这个时候，pop 出去一位：
     * stack:[1,2,【3】]  -> stack:[1,2]
     * add:[0,100,【60】] -> add:[0,【100 + 60向下合并】]  = add:[0,160]
     * 返回的是 3+60 = 63
     *
     * 再 pop 出去一位：
     * stack:[1,【2】]  -> stack:[1]
     * add:[0,【160】] -> add:[【0 + 160向下合并】]  = add:[160]
     * 返回的是 2+160 = 162
     */

    int top;
    int[] stack, add;

    public LeetCode_1381_CustomStack_v2(int maxSize) {
        top = -1;
        stack = new int[maxSize];
        add = new int[maxSize];
    }

    public void push(int x) {
        if (top != stack.length - 1) {
            stack[++top] = x;
        }
    }

    public int pop() {
        if (top == -1) {
            return -1;
        }
        int ret = stack[top] + add[top];
        if (top != 0) {
            add[top - 1] += add[top];
        }
        add[top--] = 0;
        return ret;
    }

    public void increment(int k, int val) {
        k = Math.min(k - 1, top);
        if (k >= 0) {
            add[k] += val;
        }
    }

}
