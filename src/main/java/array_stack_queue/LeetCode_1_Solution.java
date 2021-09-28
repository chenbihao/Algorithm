package array_stack_queue;

import com.sun.jdi.Value;

import java.security.Key;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: chenbihao
 * @create: 2021/9/15
 * @Description:
 * @History:
 */
public class LeetCode_1_Solution {

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && target - nums[i] == nums[i]) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(nums[i], i);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            int need = target - key;
            if (map.containsKey(need)) {
                return new int[]{map.get(need), entry.getValue()};
            }
        }
        return null;
    }

    public int[] twoSumV2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[]{};
    }
}


