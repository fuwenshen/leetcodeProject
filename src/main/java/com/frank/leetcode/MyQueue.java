package com.frank.leetcode;

import java.util.Stack;

/**
 * 232. 用栈实现队列\
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 */
public class MyQueue {


    Stack<Integer> inStack;
    Stack<Integer> outStack;


    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if(outStack.isEmpty()){
            moveIn2Out();
        }

        return outStack.pop();
    }


    public int peek() {
        if(outStack.isEmpty()){
            moveIn2Out();
        }

        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void moveIn2Out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }


}
