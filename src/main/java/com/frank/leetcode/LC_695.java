package com.frank.leetcode;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName LC_695.java
 * @Description 695. 岛屿的最大面积
 * @createTime 2022年02月17日 11:29:00
 */
public class LC_695 {



    public int maxAreaOfIsland(int[][] grid) {


        if(grid.length==0 || grid[0].length ==0){
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;

        int maxArea =0;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if(grid[i][j] == 1){
                    int area =dfsLandsArea(grid,i,j);
                    maxArea = Math.max(area,maxArea);
                }
            }
        }

        return maxArea;


    }

    private int dfsLandsArea(int[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;


        if( r<0 ||r >=nr  || c <0 || c >=nc){
            return 0;
        }
        if(grid[r][c] != 1){
            return 0;
        }

        grid[r][c]= 2;
        return 1
                +dfsLandsArea(grid,r-1,c)
                +dfsLandsArea(grid,r+1,c)
                +dfsLandsArea(grid,r,c-1)
                +dfsLandsArea(grid,r,c+1);


    }

}
