package array_stack_queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author: chenbihao
 * @create: 2021/9/12
 * @Description:
 * @History:
 */
public class LeetCode_232_ImplementQueueUsingStacksTest {

    @Test
    public void test() {

        /**
         * Your MyQueue object will be instantiated and called as such:
         * MyQueue obj = new MyQueue();
         * obj.push(x);
         * int param_2 = obj.pop();
         * int param_3 = obj.peek();
         * boolean param_4 = obj.empty();
         */

        LeetCode_232_MyQueue myQueue = new LeetCode_232_MyQueue();
        myQueue.push(1);            //queue is [1]
        myQueue.push(2);            // queue is [1, 2] (最左边是队列的前面)
        assertEquals(1, myQueue.peek());              // return 1
        assertEquals(1, myQueue.pop());                  // return 1, queue is [2]
        assertEquals(false, myQueue.empty());                // return false


    }


}
