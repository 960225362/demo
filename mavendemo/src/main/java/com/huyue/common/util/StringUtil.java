package com.huyue.common.util;


/**
 * @author huyue01@sinovatech.com 2019/4/7 16:49
 */
public class StringUtil {
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

}
