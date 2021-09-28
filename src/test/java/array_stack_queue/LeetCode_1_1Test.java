package array_stack_queue;

import junitSupport.IntArrayConverter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author: chenbihao
 * @create: 2021/9/11
 * @Description:
 * @History:
 */
public class LeetCode_1_1Test {

    @ParameterizedTest
    @CsvSource({
            "'2,7,11,15',9,'0,1'",
            "'3,2,4'    ,6,'1,2'",
            "'3,3'      ,6,'0,1'",
            "'0,4,3,0'  ,0,'0,3'",
            "'-3,4,3,90',0,'0,2'",
            "'1,1,1,1,1,4,1,1,1,1,1,7,1,1,1,1,1',11,'5,11'",
    })
    public void test(@ConvertWith(IntArrayConverter.class) int[] nums, int target, @ConvertWith(IntArrayConverter.class) int[] result) {
        int[] ints = new LeetCode_1_Solution().twoSum(nums, target);
        Assertions.assertThat(ints).contains(result);

        int[] ints2 = new LeetCode_1_Solution().twoSumV2(nums, target);
        Assertions.assertThat(ints2).contains(result);
    }

}
