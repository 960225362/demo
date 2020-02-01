package com.huyue.common.util;

import org.apache.log4j.Logger;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.List;

/**
 * SpringMVC控制器工具类
 *
 * @author nieweiren@sinovatech.com
 * @since 2012-10-15
 */
public class ControllerUtil {
    private final static Logger log = Logger.getLogger(ControllerUtil.class);

    /**
     * 防止SQL和跨站脚本
     */
    private static String[] injection
            = new String[]{"select", "exec", "like", "count", "where", "insert", "update", "delete", "and", "or ", "join",
            "union", "truncate", "drop", "script", "alert", "eval", "document", "cookie", "javascript", "script",
            "onerror", "onmouseover", "onfocus", "onerror", "embed", "CR", "LF", "svg", "confirm", "prompt", "onload"};

    /**
     * 防止SQL和跨站脚本
     *
     * @param value
     * @return
     */
    public static String proccessInjection(String value) {
        String ret = value;
        if (value != null) {
            value = value.trim().toLowerCase();
            value = EscapeUtil.escape(value);
            value = EscapeUtil.unescape(value);
            for (int j = 0; j < injection.length; j++) {
                if (value.contains(injection[j])) {
                    return "";
                }
            }
            for (int i = 0; i < value.length(); i++) {
                String x = value.substring(i, i + 1);
                if ("\n\t\r+@$;&(){}<>*|'\\\"".contains(x)) {
                    System.out.println("检测到特殊字符过滤：" + x + "(" + value + ")");
                    ret = "";
                    break;
                }
            }
            if (StringUtil.isNotEmpty(value)) {
                if ((value.contains("%0a")) || (value.contains("%0d"))) {
                    return "";
                }
            }
        }
        return ret;
    }


}
