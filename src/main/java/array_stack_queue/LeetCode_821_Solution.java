package array_stack_queue;

/**
 * @author: chenbihao
 * @create: 2021/9/11
 * @Description:
 * @History:
 */
public class LeetCode_821_Solution {

    /**
     * 给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
     * 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
     * 两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
     *
     * @param s
     * @param c
     * @return
     */
    public int[] shortestToChar(String s, char c) {
        char[] cs = new char[s.length()];
        int[] result = new int[s.length()];

        for (int i = 0; i < cs.length; i++) {
            cs[i] = s.charAt(i);
        }
        for (int i = 0; i < cs.length; i++) {
            Integer forward = null;
            Integer backward = null;
            if (cs[i] == c) {
                result[i] = 0;
                continue;
            }
            // 向前遍历
            for (int j = 1; i - j >= 0; j++) {
                if (cs[i - j] == c) {
                    forward = j;
                    break;
                }
            }
            // 向后遍历
            for (int j = 1; i + j < cs.length; j++) {
                if (cs[i + j] == c) {
                    backward = j;
                    break;
                }
            }
            if (forward==null) {
                result[i] =backward;
            }else if(backward == null){
                result[i] =forward;
            }else{
                result[i] = forward > backward ? backward : forward;
            }
        }
        return result;
    }


}
