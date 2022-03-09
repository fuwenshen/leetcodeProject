package com.frank.leetcode.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 基本计算器 II
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 */
public class LC_227 {

    public static void main(String[] args) {

        String s = "3+2*2";
        LC_227 lc_227 = new LC_227();
        int result = lc_227.calculate(s);
        System.out.println(result);
    }

    public int calculate(String s) {

        if(s == null || s.length() == 0){
            return 0;
        }

        char[] chars = s.toCharArray();

        Deque<Integer> deque = new ArrayDeque();

        for (int val: chars) {
            val = val - '0';
            int a, res;
            if (!deque.isEmpty() && '*' - '0' == deque.peek()) {
                deque.pop();
                a = deque.pop();
                res = a * val;
                deque.push(res);
            } else if (!deque.isEmpty() && '/' - '0' == deque.peek()) {
                deque.pop();
                a = deque.pop();
                res = a / val;
                deque.push(res);
            } else {
                deque.push(val);
            }
        }

        int a,res = deque.pop();;
        while (!deque.isEmpty()){
            if(!deque.isEmpty() && '+'-'0' == deque.peek()){
                 deque.pop();
                a = deque.pop();
                res = a + res;
            }else if(!deque.isEmpty() && '-'-'0' == deque.peek() ){
                deque.pop();
                a = deque.pop();
                res = a / res;
            }
        }
        return res;
    }

}
