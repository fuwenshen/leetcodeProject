package com.frank.leetcode;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName LC_5.java
 * @Description 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * @createTime 2022年02月17日 16:54:00
 */
public class LC_5 {


    public static void main(String[] args) {
        LC_5 lc5 = new LC_5();

        String s = "cbbd";
        String result = lc5.longestPalindrome(s);

        System.out.println("result="+result);
    }

    /**
     * 动态规划
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        
        int len = s.length();

        boolean[][] dp = new boolean[len][len];


        int a = 0,b=0;
        int maxLen = 0;
        for (int i = len-1; i >=0; i--) {
            for (int j = i; j < len; j++) {
                if (j - i < 1 || (j - i == 1 || dp[i + 1][j - 1]) && (s.charAt(i) == s.charAt(j))) {
                    dp[i][j] = true;

                    if (maxLen < j - i + 1) {
                        maxLen = j - i + 1;
                        a = i;
                        b = j;
                    }
                } else{
                    dp[i][j] = false;
                }

            }
        }

        return s.substring(a,b+1);

    }

    /**
     * 中心扩散法
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {


        char[] chars = s.toCharArray();

        int max=1;
        int begin=0;
        for (int i = 0; i < chars.length-1; i++) {

            int oddLength = getPalindromeLenght(chars, i, i);
            int evenLength = getPalindromeLenght(chars, i, i + 1);
            int len = Math.max(oddLength, evenLength);

            if (max < len) {
                begin = i - (len+1)/ 2 +1;
                max = len;
            }
        }


        return s.substring(begin,begin+max);

    }

    private int getPalindromeLenght(char[] chars, int left, int right) {

        if (left < 0 || left > right || right >= chars.length) {
            return 0;
        }

        while (left>=0 && right < chars.length && chars[left] == chars[right]) {
            left--;
            right++;
        }

        return right-left -1 ;
    }
}
