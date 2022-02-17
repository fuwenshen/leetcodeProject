package com.frank.leetcode;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName LC_463.java
 * @Description 463. 岛屿的周长
 * @createTime 2022年02月17日 14:27:00
 */
public class LC_463 {







    public int islandPerimeter(int[][] grid) {
        if(grid.length==0 || grid[0].length ==0){
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;

        int perimeter =0;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if(grid[i][j] == 1){
                    perimeter+=dfsLandsLength(grid,i,j);
                }
            }
        }

        return perimeter;

    }


    private int dfsLandsLength(int[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;


        if( r<0 ||r >=nr  || c <0 || c >=nc){
            return 1;
        }
        if(grid[r][c] == 0){
            return 1;
        }
        if(grid[r][c] == 2){
            return 0;
        }

        grid[r][c]= 2;
        return  dfsLandsLength(grid,r-1,c)
                +dfsLandsLength(grid,r+1,c)
                +dfsLandsLength(grid,r,c-1)
                +dfsLandsLength(grid,r,c+1);
    }
}
