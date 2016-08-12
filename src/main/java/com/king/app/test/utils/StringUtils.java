package com.king.app.test.utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description
 * PackageName: com.yeepay.g3.app.zgt.utils
 *
 * @author hua.jin
 * @since 15-5-27 下午7:32
 */
public class StringUtils {


    public static String[] inSourceNotInTarget(String[] source, String[] target) {
        List resultList = new ArrayList();
        List sourceList = Arrays.asList(source);
        List targetList = Arrays.asList(target);
        for (Iterator it = sourceList.iterator(); it.hasNext();) {
            Object candidate = it.next();
            if (!targetList.contains(candidate)) {
                resultList.add(candidate);
            }
        }
        return (String[]) resultList.toArray(new String[resultList.size()]);
    }

    public static String[] reverse(String[] source) {
        String[] result = new String[source.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = source[(result.length - i - 1)];
        }
        return result;
    }

    /**
     * 功能：判断一个字符串是否包含特殊字符
     * 
     * @param string
     *            要判断的字符串
     * @return true 提供的参数string不包含特殊字符
     * @return false 提供的参数string包含特殊字符
     */
    public static boolean isConSpeCharacters(String string) {
        // if(string.replaceAll("[\u4e00-\u9fa5]*[a-z]*[A-Z]*\\d*-*_*\\s*", "").length()==0){
        if (string.replaceAll("\\S+", "").length() == 0) {
            // 如果不包含特殊字符
            return true;
        }
        return false;
    }

    public static boolean isNotConSpeCharacters(String string) {

        return !isConSpeCharacters(string);
    }

    /**
     * 是否为中文
     * 
     * @param c
     * @return
     */
    public static boolean isChinese(char c) {

        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);

        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS

        || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS

        || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A

        || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION

        || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION

        || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {

            return true;

        }

        return false;

    }

    public static Boolean isChinese(String strName) {

        char[] ch = strName.toCharArray();
        Boolean flag = true;
        for (int i = 0; i < ch.length; i++) {

            char c = ch[i];

            // 如果有一个非中文，则返回错误
            if (isChinese(c) != true) {

                flag = false;

            }

        }
        return flag;
    }

    /**
     * 是否为 座机号
     * 
     * @param str
     * @return true 格式符合
     * @return false 格式错误
     */
    public static boolean isMobile(String str) {
        if (str == null || str == "") {
            return false;
        }
        String mobile = "^(([0\\+]\\d{2,3}(-)?)|(0\\d{2,3})(-)?)?(\\d{7,8})$";
        Pattern pattern = Pattern.compile(mobile);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();

    }

    /**
     * 是否为手机号
     * 
     * @param str
     * @return true 格式符合
     * @return false 格式错误
     */
    public static boolean isPhone(String str) {
        if (str == null || str == "") {
            return false;
        }
        String mobile = "^[1][0-9]{10}$";
        Pattern pattern = Pattern.compile(mobile);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    /**
     * 判断字符串 是否为数字
     * 
     * @param args
     * @return
     */
    public static boolean isNum(String args) {
        Pattern p = Pattern.compile("^[\\d]*"); // 正则表达式
        Matcher m = p.matcher(args);
        if (m.matches())
            return true;
        else
            return false;
    }

    /**
     * 判断字符串 是否为数字
     * 
     * @param args
     * @return
     */
    public static boolean isNotNum(String args) {
        return !isNum(args);
    }
    
    /**
     * 判断字符串 是否为数字
     * @param args
     * @return
     */
    public static boolean isEmail(String args){
        String email = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p=Pattern.compile(email);  //正则表达式
        Matcher m=p.matcher(args);
        if(m.matches())
            return true;
        else
            return false;
    }
    
    public static boolean isIP(String str) {
        Pattern pattern = Pattern
                .compile("^((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]"
                        + "|[*])\\.){3}(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]|[*])$");
        return pattern.matcher(str).matches();
    }
    

    /**
     * 字符串后补零
     *
     * @param str
     *            字符串
     * @param length
     *            补足长度
     * @return
     */
    public static String strAddZero(String str, int length) {
        String str_m = "";
        for (int i = 0; i < length; i++) {
            str_m += "0";
        }
        str = str + str_m.substring(0, length - str.length());

        return str;
    }

    /**
     * 获取两个数相除后，保留小数的结果
     * 
     * @param a
     *            除数
     * @param b
     *            被除数
     * @param length
     *            保留小数
     * @return
     */
    public static String strDivisionStr(String a, String b, int length) {
        String str_m = "0.";
        for (int i = 0; i < length; i++) {
            str_m += "0";
        }
        if (a.equals("0") || b.equals("0")) {
            return str_m;
        }
        DecimalFormat df2 = new DecimalFormat(str_m);
        return df2.format(Double.valueOf(a) / Double.valueOf(b));
    }

    /**
     * 获取两个数相除后，保留小数的结果
     * 
     * @param a
     *            除数
     * @param b
     *            被除数
     * @param length
     *            保留小数
     * @return
     */
    public static String intDivisionInt(int a, int b, int length) {
        String str_m = "0.";
        for (int i = 0; i < length; i++) {
            str_m += "0";
        }
        if (a == 0 || b == 0) {
            return str_m;
        }
        DecimalFormat df2 = new DecimalFormat(str_m);
        return df2.format(Double.valueOf(a) / Double.valueOf(b));
    }

    /**
     * 两个数值的百分比，保留两位小数
     * 
     * @param y
     * @param z
     * @return
     */
    public static String int2String(int y, int z) {
        if (y == 0 || z == 0) {
            return "0.00%";
        }
        String baifenbi = "";// 接受百分比的值
        double baiy = y * 1.0;
        double baiz = z * 1.0;
        double fen = baiy / baiz;
        // NumberFormat nf = NumberFormat.getPercentInstance(); 注释掉的也是一种方法
        // nf.setMinimumFractionDigits( 2 ); 保留到小数点后几位
        DecimalFormat df1 = new DecimalFormat("#0.00%"); // ##.00%
        // 百分比格式，后面不足2位的用0补齐
        // baifenbi=nf.format(fen);
        baifenbi = df1.format(fen);
        return baifenbi;
    }

    /**
     * 获取字符串中数字
     * 
     * @param str
     * @return
     */
    public static String getNumber(String str) {
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }

    // 判断一个字符串是否都为数字
    public boolean isDigit(String strNum) {
        return strNum.matches("[0-9]{1,}");
    }

    // 截取数字
    public String getNumbers(String content) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }

    // 截取非数字
    public String splitNotNumber(String content) {
        Pattern pattern = Pattern.compile("\\D+");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }

    /**
     * 去掉多余的.与0
     * 
     * @param s
     * @return
     */
    public static String subZeroAndDot(String s) {
        if (s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");// 去掉多余的0
            s = s.replaceAll("[.]$", "");// 如最后一位是.则去掉
        }
        return s;
    }

    /**
     * 去掉字符串后面的所有0
     * 
     * @param s
     * @return
     */
    public static String subZero(String s) {
        s = s.replaceAll("0+?$", "");// 去掉多余的0
        return s;
    }

    /**
     * 数组和是否大于指定数值,大于为true 小于为false
     * 
     * @param fee
     * @return
     */
    public static boolean validate(String[] fee, double total) {
        double sum = 0.0;
        for (int i = 0; i < fee.length; i++) {
            sum = sum + Double.parseDouble(fee[i]);
        }
        if (sum > total) {
            return true;
        }
        return false;
    }

    /**
     * 字符串前后加密加密
     * 
     * @param str
     * @return
     */
    public static String encrypt(String str) {
        if (str == null || str.length() < 8)
            return str;
        StringBuilder sb = new StringBuilder(str);
        for (int i = 3; i < str.length() - 4; i++) {
            sb.setCharAt(i, '*');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(encrypt("32312313132"));
        System.out.println(isIP("255.9.9.9"));
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str.trim())) {
            return false;
        }
        return true;
    }

    public static boolean isBlank(String str) {
        if (str == null || "".equals(str.trim())) {
            return false;
        }
        return true;
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }
}
