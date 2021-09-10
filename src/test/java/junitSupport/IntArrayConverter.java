package junitSupport;


import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

import java.util.Arrays;

/**
 * @author: chenbihao
 * @create: 2021/9/10
 * @Description: 参数化测试支持数组扩展
 * @History:
 */
public class IntArrayConverter extends SimpleArgumentConverter {

    @Override
    protected int[] convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        if (source instanceof String) {
            String[] split = ((String) source).split("\\s*,\\s*");

            int[] array = Arrays.asList(split).stream().mapToInt(Integer::parseInt).toArray();
            return array;

        } else {
            throw new IllegalArgumentException("Conversion from " + source.getClass() + " to "
                    + targetType + " not supported.");
        }
    }

}
