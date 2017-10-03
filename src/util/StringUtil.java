package util;

/**
 * Author: liuxiao
 * Created: 2017/10/3 10:50
 * Description:
 */
public class StringUtil {

    public static boolean isEmpty(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        return false;
    }

    public static String removeBlank(String s) {
        return s.replace(" ", "");
    }

    public static String removeBracket(String s) {
        int startIndex = 0;
        boolean hasBracket = false;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (s.charAt(i) == '(') {
                startIndex = i;
                hasBracket = true;
                break;
            }
        }
        if (hasBracket) {
            s = s.substring(0, startIndex - 1);
        }
        return s;
    }

}
