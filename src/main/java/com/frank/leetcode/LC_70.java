package com.frank.leetcode;

public class LC_70 {


    public static void main(String[] args) {
        int n = 5;
    }

    /**
     *   f(n) = f(n-1)+f(n-2)
     * @param n
     * @return
     */
    public int climbStairs(int n) {


        if(n <= 2){
            return n;
        }

        int[] f = new int[n+1];

        f[1] = 1;
        f[2] = 1;

        for (int i =3; i <= n ; i++) {
            f[i] = f[i-1] +f[i-2];
        }

        return f[n];


    }


    public int climbStairs1(int n) {


        if(n <= 2){
            return n;
        }

        int one_step = 1;
        int two_step = 2;

        int all_step= 0;

        for (int i = 2; i <= n ; i++) {

            all_step = one_step +two_step;

           two_step = one_step;
           one_step = all_step;

        }
        return all_step;

    }


    public int climbStairs2(int n) {

        if(n <= 2){
            return n;
        }

        return climbStairs2(n-1) +climbStairs2(n-2);

    }
}
