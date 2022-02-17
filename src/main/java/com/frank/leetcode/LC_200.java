package com.frank.leetcode;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName LeetCode_200.java
 * @Description 200. 岛屿数量
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3

 * @createTime 2022年02月17日 10:24:00
 */
public class LC_200 {


    public static void main(String[] args) {
        //char [][] grid = {{"1","1","1","1","0"},{"1","1","0","1","0"},{"1","1","0","0","0"},{"0","0","0","0","0"}};
    }

    /**
     *  用于 前后左右遍历
     */
    int[] move_x = {-1,1,0,0};
    int[] move_y = {0,0,-1,1};


    public int numIslands(char[][] grid) {

        int m = grid[0].length;
        int n = grid.length;

        // 遍历的陆地标记为1
        int[][]  passLand = new int[n][m];

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] =='1' && passLand[i][j]!='1'){
                    count ++;
                    dfsIslands(grid,passLand,i,j);

                }
            }
        }


        return count;

    }

    private void dfsIslands(char[][] grid, int[][] passLand, int x, int y) {
        int m = grid[0].length;
        int n = grid.length;

        if( x<0 ||x >=m  || y <0 || y >=n){
            return;
        }
        if(grid[x][y] == '0' || passLand[x][y] =='1'){
            return;
        }

        passLand[x][y] = '1';

        for (int i = 0; i < 4; i++) {
            dfsIslands(grid,passLand,x+move_x[i],y+move_y[i]);
        }

    }



}
