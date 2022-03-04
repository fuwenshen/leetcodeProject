package com.frank.leetcode;

import java.util.Arrays;

public class LC_62 {


    public static void main(String[] args) {
        int m = 3,n=2;
        LC_62 lc_62 = new LC_62();

        int result = lc_62.uniquePaths(m, n);

        System.out.println("result="+result);
    }

    public int uniquePaths(int m, int n) {

        int [][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m-1][n-1];
    }
}
