package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: chenbihao
 * @create: 2021/9/10
 * @Description:
 * @History:
 */
public class LeetCode_989_AddToArrayFormOfInteger {

    /**
     * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
     * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
     *
     * @param num
     * @param k
     * @return
     */
    public List<Integer> addToArrayForm(int[] num, int k) {

        // 先转int[] 再去加   进位字段
        String kStr = String.valueOf(k);
        int[] kArray = getIntArray(kStr);

        List<Integer> result;

        // 计算并取进位
        if (num.length >= kArray.length) {
            result = calculate(num, kArray);
        } else {
            result = calculate(kArray, num);
        }
        return result;

    }

    /**
     * 计算
     *
     * @param longer
     * @param shorter
     * @return
     */
    private List<Integer> calculate(int[] longer, int[] shorter) {
        int carry = 0;
        for (int i = 0; i < longer.length; i++) {
            int longerLen = longer.length - i - 1;
            int shorterLen = shorter.length - i - 1;

            if (shorterLen >= 0) {
                int i1 = shorter[shorterLen] + longer[longerLen] + carry;
                longer[longerLen] = i1 % 10;
                carry = i1 / 10;
            } else {
                // 当k比num位数少的时候，还得计算完进位的情况
                if (carry != 0) {
                    int i1 = longer[longerLen] + carry;
                    longer[longerLen] = i1 % 10;
                    carry = i1 / 10;
                }
            }
        }

        // 判断最后有没有进位，有的话补上
        List<Integer> result = Arrays.stream(longer).boxed().collect(Collectors.toList());
        if (carry != 0) {
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(carry);
            integers.addAll(result);
            result = integers;
        }
        return result;
    }

    private int[] getIntArray(String str) {
        int[] ints = new int[str.length()];
        for (int i = 0; i < ints.length; i++) {
            Character ch = str.charAt(i);
            ints[i] = Integer.parseInt(ch.toString());
        }
        return ints;
    }


}
