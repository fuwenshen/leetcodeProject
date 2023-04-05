package com.frank.leetcode;

import java.util.Stack;


public class LC_42 {


    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
      //  int[] height = {4,2,0,3,2,5};

        LC_42 lc = new LC_42();

        int res = lc.trap(height);
        System.out.println(res);
    }

    public int trap(int[] height) {

        if(height == null || height.length ==0){
            return 0;
        }
        // 用于临时记录前一步计算过的高度，
        int preHeight =0;

        Stack<Integer> stack = new Stack<>();

        int are=0;
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            int h = height[i];
            // 遇到比当前栈里面大的就开始就算积水面积
            if (h >= height[stack.peek()]) {
                while (!stack.isEmpty()) {
                    Integer a = stack.peek();
                    int l = i - a - 1;
                    if (h >= height[a]) {
                        stack.pop();
                        
                        int b = height[a] - preHeight;

                        are = are + (l * b);
                        preHeight = height[a];
                    } else {
                        are = are + (l * (h - preHeight));
                        preHeight = h;
                        break;
                    }
                }
            }

            stack.push(i);
        }
        return are;

    }
}
