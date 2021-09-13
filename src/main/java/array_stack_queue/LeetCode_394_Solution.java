package array_stack_queue;

import java.util.Stack;

/**
 * @author: chenbihao
 * @create: 2021/9/13
 * @Description:
 * @History:
 */
public class LeetCode_394_Solution {

    /**
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     * <p>
     * 输入：s = "3[a]2[bc]"   输出："aaabcbc"
     * 输入：s = "3[a2[c]]"   输出："accaccacc"
     * 输入：s = "2[abc]3[cd]ef"  输出："abcabccdcdcdef"
     * 输入：s = "abc3[cd]xyz"  输出："abccdcdcdxyz"
     */
    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack();
        Stack<String> StrStack = new Stack();
        String count = "";
        String str = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                // 遇到数字就记录   也可以用这个来判断是否数字：  if (Character.isDigit(c)) {
                count += Integer.parseInt(String.valueOf(c));
            } else if (c == '[') {
                // 遇到左括号就入栈
                countStack.push(Integer.parseInt(count));
                StrStack.push(str);
                count = str = "";
            } else if (c == ']') {
                // 遇到右括号就出栈
                Integer c1 = countStack.pop();
                String temp = "";
                for (int j = 0; j < c1; j++) {
                    temp += str;
                }
                str = StrStack.pop() + temp;
            } else {
                // 记录字母
                str += c;
            }
        }
        return str;
    }
}
