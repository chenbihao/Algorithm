package array;

import junitSupport.IntArrayConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author: chenbihao
 * @create: 2021/9/10
 * @Description:
 * @History:
 */
public class LeetCode_821_ShortestDistanceToACharacterTest {

    @ParameterizedTest
    @CsvSource({
            "'aaab', 'b', '3,2,1,0'",
            "'loveleetcode', 'e', '3,2,1,0,1,0,0,1,2,2,1,0'"
    })
    public void test(String s, char c, @ConvertWith(IntArrayConverter.class) int[] result) {
        assertArrayEquals(result, new LeetCode_821_ShortestDistanceToACharacter().shortestToChar(s, c));
    }


}
