package com.frank.leetcode;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName LC_48.java
 * @Description TODO
 * @createTime 2022年02月22日 17:53:00
 */
public class LC_48 {


    public static void main(String[] args) {
        int [][]matrix =  {{1,2,3},{4,5,6},{7,8,9}};


        LC_48 lc_48 = new LC_48();
        lc_48.rotate(matrix);
    }

    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length ==0  || matrix[0].length == 0){
            return;
        }

        int nr = matrix.length;
        int nc = matrix[0].length;

        for (int i = 0; i < nr/2; i++) {
            for (int j = 0; j < nc; j++) {
                int temp =  matrix[i][j];
                matrix[i][j] = matrix[nr -1 -i][j];
                matrix[nr -1 -i][j] = temp;
            }
        }

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }
}
