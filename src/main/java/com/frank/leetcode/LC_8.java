package com.frank.leetcode;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName LC_8.java
 * @Description TODO
 * @createTime 2022年03月04日 12:38:00
 */
public class LC_8 {


    public static void main(String[] args) {
        String s = "-91283472332";

        LC_8 lc = new LC_8();

        int res = lc.myAtoi(s);

        System.out.println(res);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    public int myAtoi1(String str) {
        int len = str.length();
        // str.charAt(i) 方法回去检查下标的合法性，一般先转换成字符数组
        char[] charArray = str.toCharArray();

        // 1、去除前导空格
        int index = 0;
        while (index < len && charArray[index] == ' ') {
            index++;
        }

        // 2、如果已经遍历完成（针对极端用例 "      "）
        if (index == len) {
            return 0;
        }

        // 3、如果出现符号字符，仅第 1 个有效，并记录正负
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 4、将后续出现的数字字符进行转换
        // 不能使用 long 类型，这是题目说的
        int res = 0;
        while (index < len) {
            char currChar = charArray[index];
            // 4.1 先判断不合法的情况
            if (currChar > '9' || currChar < '0') {
                break;
            }

            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            // 4.2 合法的情况下，才考虑转换，每一步都把符号位乘进去
            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;
    }


    public int myAtoi(String s) {


        StringBuilder sb = new StringBuilder();
        s = s.trim();
        Long value = 0L;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c == '+' || c == '-') && sb.length() == 0) {
                sb.append(c);
                continue;
            }

            if(c < '0' || c > '9'){
                break;
            }

            sb.append(c);

            value = Long.valueOf(sb.toString());
            if(value>Integer.MAX_VALUE){
                value = Long.valueOf(Integer.MAX_VALUE);
                break;
            }
            if(value< Integer.MIN_VALUE){
                value = Long.valueOf(Integer.MIN_VALUE);
                break;
            }
        }
        return value.intValue();
    }
}
