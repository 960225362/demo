package com.example.demo.common.utils;

/**
 * @author huyue01@sinovatech.com 2019/6/23 16:49
 */
public class CharacterUtil {
    /**
     * 半角对应ASCII表中可见字符从!开始，偏移位值为33(Decimal)
     */
    private static final char DBC_CHAR_START = 33;

    /**
     * 半角对应ASCII表中可见字符到~结束，偏移位值为126(Decimal)
     */
    private static final char DBC_CHAR_END = 126;

    /**
     * 全角对应于ASCII表的可见字符从！开始，偏移值为65281
     */
    private static final char SBC_CHAR_START = 65281;

    /**
     * 全角对应于ASCII表的可见字符到～结束，偏移值为65374
     */
    private static final char SBC_CHAR_END = 65374;

    /**
     * ASCII表中除空格外的可见字符与对应的全角字符的相对偏移
     */
    private static final int CONVERT_STEP = 65248;

    /**
     * 全角空格的值，它没有遵从与ASCII的相对偏移，必须单独处理
     */
    private static final char SBC_SPACE = 12288;

    /**
     * 半角空格的值，在ASCII中为32(Decimal)
     */
    private static final char DBC_SPACE = 32;

    /**
     * <PRE>
     * 半角字符->全角字符转换
     * 只处理空格，!到˜之间的字符，忽略其他
     * </PRE>
     */
    private static String bj2qj(String src) {
        if (src == null) {
            return null;
        }
        StringBuilder buf = new StringBuilder(src.length());
        char[] ca = src.toCharArray();
        for (char c : ca) {
            if (c == DBC_SPACE) { // 如果是半角空格，直接用全角空格替代
                buf.append(SBC_SPACE);
            } else if ((c >= DBC_CHAR_START) && (c <= DBC_CHAR_END)) { // 字符是!到~之间的可见字符
                buf.append((char) (c + CONVERT_STEP));
            } else { // 不对空格以及ascii表中其他可见字符之外的字符做任何处理
                buf.append(c);
            }
        }
        return buf.toString();
    }

    /**
     * <PRE>
     * 全角字符->半角字符转换
     * 只处理全角的空格，全角！到全角～之间的字符，忽略其他
     * </PRE>
     */
    private static String qj2bj(String src) {
        if (src == null) {
            return null;
        }
        StringBuilder buf = new StringBuilder(src.length());
        char[] ca = src.toCharArray();
        for (char c : ca) {
            if (c == SBC_SPACE) {
                buf.append(DBC_SPACE);
            } else if (c >= SBC_CHAR_START && c <= SBC_CHAR_END) {
                buf.append((char) (c - CONVERT_STEP));
            } else {
                buf.append(c);
            }
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        String s1 = "gsrtt　art　j r　ｓｆｗｅｅｇａｒｖ　哈哈哈";
        String s2 = "erg Ｄｄｃａ　　　　　　　ｓｄｖｄｖ７７７７７４ａａａ好啊　好啊";
        String s3 = "　11";
        String s4 = "  11";
        System.out.println(s1 + "==" + qj2bj(s1));
        System.out.println(s2 + "==" + qj2bj(s2));
        System.out.println(s3 + "==" + qj2bj(s3));
        System.out.println(s4 + "==" + qj2bj(s4));
        System.out.println(s1 + "==" + bj2qj(s1));
        System.out.println(s2 + "==" + bj2qj(s2));
        System.out.println(s3 + "==" + bj2qj(s3));
        System.out.println(s4 + "==" + bj2qj(s4));
    }
}
