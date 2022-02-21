package com.frank.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName LC54.java
 * @Description 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * @createTime 2022年02月21日 12:18:00
 */
public class LC54 {


    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix = {{1, 2},{ 3, 4}};

        LC54 lc54 = new LC54();

        List<Integer> list = lc54.spiralOrder(matrix);


        list.forEach(value -> System.out.println("value=" + value));

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }

        int nr = matrix.length;
        int nc = matrix[0].length;

        int startR = 0, endR = nr - 1;
        int startC = 0, endC = nc - 1;

        List<Integer> result = new ArrayList<>();
        while (startR <= endR && startC <= endC) {

            int r = startR;
            int c = startC;

            // 向右   -->
            while (startR <= endR && c <= endC) {
                result.add(matrix[r][c]);
                c++;
            }

            // 行数往下  +1
            r = ++startR;
            c = endC;

            //向下
            while (r <= endR && startC <= endC) {
                result.add(matrix[r][c]);
                r++;
            }


            r = endR;
            // 列数往走 -1
            c = --endC;
            // 向左
            while (startR <= endR && c >= startC) {
                result.add(matrix[r][c]);
                c--;
            }

            //向上
            // 行数往上 -1
            r = --endR;
            c = startC;
            while (r >= startR && startC <= endC) {
                result.add(matrix[r][c]);
                r--;
            }

            // 列数 向右边 +1
            ++startC;
        }


        return result;

    }

}
