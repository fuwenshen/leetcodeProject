package com.frank.leetcode;

import java.util.Stack;

public class LC_415 {


    public static void main(String[] args) {
        String num1 = "555";
        String num2 = "555";
        LC_415 lc = new LC_415();


        String res = lc.addStrings(num1, num2);

        System.out.println(res);
    }


    public String addStrings(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int carry = 0;

        StringBuilder result = new StringBuilder();
        while (l1 > 0 || l2 > 0) {

            int a = l1 > 0 ? num1.charAt(l1 - 1) - '0' : 0;
            int b = l2 > 0 ? num2.charAt(l2 - 1) - '0' : 0;

            int res = a + b + carry;

            carry = res / 10;
            result.append(res % 10);
            l1--;
            l2--;
        }
        if (carry > 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }


    public String addStrings1(String num1, String num2) {

        int l1 = num1.length();
        int l2 = num2.length();

        Stack<Integer> stack = new Stack<>();
        int carry = 0;
        while (l1>0 && l2>0){

          int addValue =  num1.charAt(l1-1)-'0'+ num2.charAt(l2-1)-'0' +carry;
          carry = 0 ;

          if(addValue - 10>=0){
              carry = 1;
              addValue = addValue - 10;
          }
            stack.push(addValue);
          l1--;
          l2--;
        }



        while (carry>0){
            int a = 0;
            if(l1>0){
                a = num1.charAt(l1-1)-'0';
                l1--;
            }
            if(l2>0){
                a = num2.charAt(l2-1)-'0';
                l2 --;
            }

            int res = a +carry;
            carry = 0;
            if(res >=10){
                res = res -10;
                carry = 1;
            }
            stack.push(res);
        }

        StringBuilder result  = new StringBuilder();
        if(l1>0){
            result.append(num1.substring(0,l1));
        }
        if(l2>0){
            result.append(num2.substring(0,l2));
        }


        while (!stack.isEmpty()){
            result.append(stack.pop());
        }

        return result.toString();

    }
}
