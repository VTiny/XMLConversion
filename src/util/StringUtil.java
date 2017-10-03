package util;

/**
 * Author: liuxiao
 * Created: 2017/10/3 10:50
 * Description: 字符串操作工具类
 */
class StringUtil {

    /**
     * 判断字符串是否为空
     * @param s
     * @return
     */
    public static boolean isEmpty(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 删除字符串中的空格
     * @param s
     * @return
     */
    public static String removeBlank(String s) {
        return s.replace(" ", "");
    }

    /**
     * 删除字符串中的括号
     * TODO 改用正则
     * @param s
     * @return
     */
    public static String removeBracket(String s) {
        int index = 0;
        boolean hasBracket = false;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (s.charAt(i) == '(') {
                index = i;
                hasBracket = true;
                break;
            }
        }
        if (hasBracket) {
            s = s.substring(0, index);
        }
        return s;
    }

    /**
     * 删除字符串中的后缀名
     * @param s
     * @return
     */
    public static String removeSuffix(String s) {
        int index = 0;
        boolean hasSuffix = false;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (s.charAt(i) == '.') {
                index = i;
                hasSuffix = true;
                break;
            }
        }
        if (hasSuffix) {
            s = s.substring(0, index);
        }
        return s;
    }

}
