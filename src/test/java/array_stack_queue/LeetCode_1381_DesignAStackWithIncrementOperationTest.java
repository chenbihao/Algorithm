package array_stack_queue;

import junitSupport.IntArrayConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.converter.ConvertWith;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author: chenbihao
 * @create: 2021/9/12
 * @Description:
 * @History:
 */
public class LeetCode_1381_DesignAStackWithIncrementOperationTest {

    @Test
    public void test() {

        /**
         * Your CustomStack object will be instantiated and called as such:
         * CustomStack obj = new CustomStack(maxSize);
         * obj.push(x);
         * int param_2 = obj.pop();
         * obj.increment(k,val);
         */

        LeetCode_1381_CustomStack customStack = new LeetCode_1381_CustomStack(3);

        customStack.push(1);// 栈变为 [1]
        customStack.push(2);// 栈变为 [1, 2]
        assertEquals(2, customStack.pop()); // 返回 2 --> 返回栈顶值 2，栈变为 [1]
        customStack.push(2);// 栈变为 [1, 2]
        customStack.push(3);// 栈变为 [1, 2, 3]
        customStack.push(4);   // 栈仍然是 [1, 2, 3]，不能添加其他元素使栈大小变为 4
        customStack.increment(5, 100); // 栈变为 [101, 102, 103]
        customStack.increment(2, 100);// 栈变为 [201, 202, 103]
        assertEquals(103, customStack.pop()); // 返回 103 --> 返回栈顶值 103，栈变为 [201, 202]
        assertEquals(202, customStack.pop());// 返回 202 --> 返回栈顶值 202，栈变为 [201]
        assertEquals(201, customStack.pop());  // 返回 201 --> 返回栈顶值 201，栈变为 []
        assertEquals(-1, customStack.pop());   // 返回 -1 --> 栈为空，返回 -1

    }


    @Test
    public void testV2() {

        /**
         * 优化版
         * 差分数组|
         */

        LeetCode_1381_CustomStack_v2 customStack = new LeetCode_1381_CustomStack_v2(3);

        customStack.push(1);// 栈变为 [1]
        customStack.push(2);// 栈变为 [1, 2]
        assertEquals(2, customStack.pop()); // 返回 2 --> 返回栈顶值 2，栈变为 [1]
        customStack.push(2);// 栈变为 [1, 2]
        customStack.push(3);// 栈变为 [1, 2, 3]
        customStack.push(4);   // 栈仍然是 [1, 2, 3]，不能添加其他元素使栈大小变为 4
        customStack.increment(5, 100); // 栈变为 [101, 102, 103]
        customStack.increment(2, 100);// 栈变为 [201, 202, 103]
        assertEquals(103, customStack.pop()); // 返回 103 --> 返回栈顶值 103，栈变为 [201, 202]
        assertEquals(202, customStack.pop());// 返回 202 --> 返回栈顶值 202，栈变为 [201]
        assertEquals(201, customStack.pop());  // 返回 201 --> 返回栈顶值 201，栈变为 []
        assertEquals(-1, customStack.pop());   // 返回 -1 --> 栈为空，返回 -1

    }

}
