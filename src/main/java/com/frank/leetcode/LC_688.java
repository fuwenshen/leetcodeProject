package com.frank.leetcode;

import java.util.Arrays;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName LC_688.java
 * @Description 骑士在棋盘上的概率
 * 在一个 n x n 的国际象棋棋盘上，一个骑士从单元格 (row, column) 开始，并尝试进行 k 次移动。
 * 行和列是 从 0 开始 的，所以左上单元格是 (0,0) ，右下单元格是 (n - 1, n - 1) 。

 * @createTime 2022年02月17日 14:47:00
 */
public class LC_688 {


    public static void main(String[] args) {

       int  n = 3, k = 2, row = 0, column = 0;

       LC_688 lc688 = new LC_688();
        double result = lc688.knightProbability(n, k, row, column);

        System.out.println("result="+result);
    }


    public double knightProbability(int n, int k, int row, int column) {

        int [][]dirPath = {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};

        double [][][]dp = new double[k+1][n][n];
        dp[0][row][column] =1;


        for (int step = 0;step < k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 第step步到 i,j的概率要大于0
                    if (dp[step][i][j] > 0) {
                        for (int[] dir : dirPath) {
                            int r = i + dir[0];
                            int c = j + dir[1];
                            if (r >= 0 && r < n && c >= 0 && c < n) {
                               // System.out.println("*  **step="+ step +",i=" +i +",j="+j +"，result"+dp[step][i][j]);
                                dp[step + 1][r][c] += dp[step][i][j] * 1 / 8;
                               // System.out.println("===step+1="+ (step+1) +",r=" +r +",c="+c +"，result"+dp[step + 1][r][c]);
                            }
                        }
                    }
                }
            }
        }

        // 输出第k步的结果
        double result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += dp[k][i][j];
            }

        }

        return result;

    }

}
