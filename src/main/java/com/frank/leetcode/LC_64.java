package com.frank.leetcode;

/**
 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 */
public class LC_64 {


    public static void main(String[] args) {
        int [][]grid = {{1,3,1},{1,5,1},{4,2,1}};

        LC_64 lc_64 = new LC_64();


        int result = lc_64.minPathSum(grid);

        System.out.printf("result="+result);
    }

    public int minPathSum(int[][] grid) {

        if(grid.length ==0 || grid[0].length ==0){
            return 0;
        }

        return dfs(grid,0,0);
    }


    private int dfs(int[][] grid, int r, int c) {

        int nr = grid.length;
        int nc = grid[0].length;

        if(r == nr-1  && c == nc-1){
            return grid[r][c];
        }

        int minPath;
        if( c == nc-1){
            minPath = dfs(grid, r + 1, c);
        }else if(r == nr-1){
            minPath = dfs(grid, r, c + 1);
        }else{
            int right = dfs(grid, r + 1, c);
            int down = dfs(grid, r, c + 1);
            minPath = Math.min(right, down);
        }

        return minPath + grid[r][c];

    }





    public int minPathSum1(int[][] grid) {


        if(grid.length ==0 || grid[0].length ==0){
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;

        int[][] dp = new int[nr+1][nc+1];

        for (int i = 1; i <= nr; i++) {

            for (int j = 1; j <= nc; j++) {

                if (i - 1 == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i - 1][j - 1];
                }else if (j - 1 == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
                }
            }
        }

        return dp[nr][nc];
    }


}
