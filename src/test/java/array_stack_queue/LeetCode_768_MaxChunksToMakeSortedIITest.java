package array_stack_queue;

import junitSupport.IntArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author: chenbihao
 * @create: 2021/9/11
 * @Description:
 * @History:
 */
public class LeetCode_768_MaxChunksToMakeSortedIITest {

    @ParameterizedTest
    @CsvSource({
            "'5,4,3,2,1',1",
            "'2,1,3,4,4',4",
    })
    public void test(@ConvertWith(IntArrayConverter.class) int[] arr, int result) {
        assertEquals(result, new LeetCode_768_Solution().maxChunksToSorted(arr));
    }


}
