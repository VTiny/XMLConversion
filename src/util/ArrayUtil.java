package util;

import java.util.Arrays;
import java.util.List;

/**
 * Author: liuxiao
 * Created: 2017/10/3 10:45
 * Description:
 */
public class ArrayUtil<T> {

    public static String[] removeBlankString(String[] stringArr) {
        List<String> stringList = Arrays.asList(stringArr);
        int size = stringArr.length;
        for (int i = 0, len = stringArr.length; i < len; i++) {
            if (StringUtil.isEmpty(stringArr[i])) {
                size--;
            }
        }
        String[] resStringArr = new String[size];
        for (int i = 0; i < size; i++) {
            resStringArr[i] = stringArr[i];
        }
        return resStringArr;
    }


}
