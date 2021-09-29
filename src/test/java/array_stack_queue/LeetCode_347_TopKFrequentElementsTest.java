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
public class LeetCode_347_TopKFrequentElementsTest {

    @ParameterizedTest
    @CsvSource({
            "'1,1,1,2,2,3',2,'1,2'",
            "'1',1,'1'",
    })
    public void test(@ConvertWith(IntArrayConverter.class) int[] nums, int target, @ConvertWith(IntArrayConverter.class) int[] result) {

        int[] ints = new LeetCode_347_Solution().topKFrequent(nums, target);
        Assertions.assertThat(ints).contains(result);

    }

}
