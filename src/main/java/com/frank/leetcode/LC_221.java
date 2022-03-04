package com.frank.leetcode;

import javax.swing.*;

public class LC_221 {


    public static void main(String[] args) {
      // char [][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
       char [][] matrix = {{'0','1','1','0','0','1','0','1','0','1'},{'0','0','1','0','1','0','1','0','1','0'},{'1','0','0','0','0','1','0','1','1','0'},{'0','1','1','1','1','1','1','0','1','0'},{'0','0','1','1','1','1','1','1','1','0'},{'1','1','0','1','0','1','1','1','1','0'},{'0','0','0','1','1','0','0','0','1','0'},{'1','1','0','1','1','0','0','1','1','1'},{'0','1','0','1','1','0','1','0','1','1'}};

       LC_221 lc_221 = new LC_221();
        int result = lc_221.maximalSquare(matrix);

        System.out.println("result="+result);

    }

    public int maximalSquare(char[][] matrix) {

        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int nr = matrix.length;
        int nc = matrix[0].length;

        int maxArea = 0;

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {

                if(matrix[i][j] == '1'){
                    int area = 1;
                    int k= 1;

                    // 从右和下，依次检查是否都都是1
                    while (i+k <nr && j+k <nc){
                        boolean isOk = true;
                        for (int l = 0; l <=k ; l++) {
                            // 如果出现为0，那就结束
                            if(matrix[i+ k][j+l] == '0' || matrix[i+l][j+k] =='0'){
                                isOk =false;
                                break;
                            }
                        }

                        if(!isOk){
                            break;
                        }

                        k++;
                        area = (k)*(k);
                    }

                    maxArea = Math.max(maxArea,area);
                }
            }
        }

        return maxArea;

    }

}
