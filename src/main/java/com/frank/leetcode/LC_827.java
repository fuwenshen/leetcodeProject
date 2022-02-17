package com.frank.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName LC_695.java
 * @Description 最大人工岛
 * @createTime 2022年02月17日 11:29:00
 */
public class LC_827 {


    public static void main(String[] args) {

        int[][] grid = {{1,1},{1,1}};

        LC_827 lc_827 = new LC_827();


        int result = lc_827.largestIsland(grid);

        System.out.println("result="+result);

    }

    /**
     *  用于 前后左右遍历
     */
    int[] move_x = {-1,1,0,0};
    int[] move_y = {0,0,-1,1};

    public int largestIsland(int[][] grid) {

        if(grid.length==0 || grid[0].length ==0){
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;


        int tag = 10;
        int maxArea =0;
        Map<Integer,Integer> areaMap = new HashMap();
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if(grid[i][j] == 1){
                    int area =dfsLandsArea(grid,i,j,++tag);
                    areaMap.put(tag,area);
                    maxArea = Math.max(maxArea,area);
                }
            }
        }


        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                //遍历海洋
                if (grid[i][j] == 0) {
                    Set<Integer> tagSet = new HashSet();
                    // 遍历新填陆地的相邻位置
                    for (int k = 0; k < 4; k++) {
                        int tr = i + move_x[k];
                        int tc = j + move_y[k];

                        if( tr>=0 && tr < nr  && tc >=0 &&  tc < nc){
                            if (grid[tr][tc] > 0) {
                                tagSet.add(grid[tr][tc]);
                            }
                        }
                    }

                    // 计算人工岛屿面积
                    int newArea = 1;
                    Iterator<Integer> iterator = tagSet.iterator();
                    while (iterator.hasNext()){
                        newArea +=areaMap.get(iterator.next());
                    }
                    maxArea = Math.max(maxArea, newArea);
                }
            }
        }

        return maxArea;
    }


    private int dfsLandsArea(int[][] grid, int r, int c,int tag) {
        int nr = grid.length;
        int nc = grid[0].length;


        if( r<0 ||r >=nr  || c <0 || c >=nc){
            return 0;
        }
        if(grid[r][c] != 1){
            return 0;
        }

        grid[r][c]= tag;
        return 1
                +dfsLandsArea(grid,r-1,c,tag)
                +dfsLandsArea(grid,r+1,c,tag)
                +dfsLandsArea(grid,r,c-1,tag)
                +dfsLandsArea(grid,r,c+1,tag);


    }

}
