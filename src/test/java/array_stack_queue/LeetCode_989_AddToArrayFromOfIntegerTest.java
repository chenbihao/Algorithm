package array_stack_queue;

import junitSupport.IntArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: chenbihao
 * @create: 2021/9/10
 * @Description:
 * @History:
 */
public class LeetCode_989_AddToArrayFromOfIntegerTest {

    @ParameterizedTest
    @CsvSource({
            "'1,2,0,0', 34, '1,2,3,4'",
            "'2,7,4', 181, '4,5,5'",
            "'2,1,5', 806, '1,0,2,1'",
            "'9,9,9,9,9,9,9,9,9,9', 1, '1,0,0,0,0,0,0,0,0,0,0'",
            "'0', 23, '2,3'"
    })
    public void test(@ConvertWith(IntArrayConverter.class) int[] num, int k
            , @ConvertWith(IntArrayConverter.class) int[] result) {
        assertArrayEquals(result,getIntArray(new LeetCode_989_Solution().addToArrayForm(num,k)));
    }


    private int[] getIntArray(List<Integer> list){
        if (list==null) {
            return null;
        }
        int[] d = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            d[i] = list.get(i);
        }
        return d;
    }

}
