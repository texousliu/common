package com.texous.common.utils;

import java.util.Locale;

/**
 * insert description here
 *
 * @author liuxiaohua
 * @since 2018/7/26 11:31
 */
public class StringUtils {

    /**
     * 判断是否为 null 或者 "" 字符串
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    /**
     * 判断是否为 null 或者 只有空格的字符串
     * @param str
     * @return
     */
    public static boolean isTrimEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    /**
     * 将驼峰转化为下划线
     * @param name
     * @return
     */
    public static String underscoreName(String name) {
        if (StringUtils.isTrimEmpty(name)) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        result.append(lowerCaseName(name.substring(0, 1)));

        for(int i = 1; i < name.length(); ++i) {
            String s = name.substring(i, i + 1);
            String slc = lowerCaseName(s);
            if (!s.equals(slc)) {
                result.append("_").append(slc);
            } else {
                result.append(s);
            }
        }

        return result.toString();
    }

    /**
     * 将下划线转换为驼峰标识
     * @param name
     * @return
     */
    public static String humpName(String name) {
        if (StringUtils.isTrimEmpty(name)) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        boolean needUpper = false;
        for(int i = 0; i < name.length(); ++i) {
            if ('_' == name.charAt(i)) {
                needUpper = true;
                continue;
            } else {
                if (needUpper) {
                    result.append(upperCaseName(name.substring(i, i+1)));
                    needUpper = false;
                } else
                    result.append(name.charAt(i));
            }
        }

        return result.toString();

    }

    /**
     * 英文字母转换为小写
     * @param name
     * @return
     */
    public static String lowerCaseName(String name) {
        return name.toLowerCase(Locale.US);
    }

    /**
     * 英文字母转换为大写
     * @param name
     * @return
     */
    public static String upperCaseName(String name) {
        return name.toUpperCase(Locale.US);
    }

    public static void main(String[] args) {
        String str = underscoreName("aaBBcddSSd");
        System.out.println(str);
        System.out.println(humpName(str));
        System.out.println(lowerCaseName("AADdadsSDDD你好啊"));
        System.out.println(upperCaseName("AADdadsSDDD你好啊"));
    }
}
