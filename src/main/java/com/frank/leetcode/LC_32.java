package com.frank.leetcode;

public class LC_32 {


    public static void main(String[] args) {
       // String s = "()(())";
       // String s = ")()())";
        String s = "(()(((()";

        LC_32 lc_32 = new LC_32();
        int result = lc_32.longestValidParentheses(s);

        System.out.println("result="+result);


    }

    private int longestValidParentheses(String s) {


        return 0;
    }


    /**
     *   有问题的算法
    public int longestValidParentheses(String s) {

        int max = 0;
        int leftCount = 0;
        int bracketsCount = 0;
        int currCount = 0;
        // 判断是否要合并结果 ， ()(()) 情况
        boolean continues = false;

        for (int i = 0; i < s.length(); i++) {
            //处理左括号匹配完的情况
            if (leftCount == 0 && currCount > 0) {

                bracketsCount = continues ? bracketsCount + currCount : currCount;
                max = Math.max(max, bracketsCount);

                // 根据条件重新赋值

                continues = s.charAt(i) == '(' ? true : false;

                currCount = 0;
            }

            // （ 进行数量标记
            if (s.charAt(i) == '(') {
                leftCount++;
                continue;
            }

            if (leftCount > 0) {
                leftCount--;
                currCount++;
            }
        }


        if (continues && leftCount == 0) {
            bracketsCount = bracketsCount + currCount;
        } else {
            bracketsCount = currCount;
        }

        max = Math.max(max, bracketsCount);

        return 2 * max;
    }

     */


}
