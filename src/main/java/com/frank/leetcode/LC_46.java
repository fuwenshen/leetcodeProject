package com.frank.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName LC_46.java
 * @Description 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * @createTime 2022年05月30日 18:15:00
 */
public class LC_46 {


    public static void main(String[] args) {
        int[] nums = {1,2,3};

        LC_46 lc_46 = new LC_46();

        List<List<Integer>> permute = lc_46.permute(nums);


        permute.forEach(key->{
            key.forEach(k -> System.out.print(k));
            System.out.println();
        });


    }


    public List<List<Integer>> permute(int[] nums) {

        boolean[] useNums =  new boolean[nums.length];

        List result = new ArrayList<>();
        DFS(nums,useNums,0,new ArrayList(),result);
        return result;
    }



    public void DFS(int[] nums,boolean[] useNums, int depth, List path, List<List> result){
        // terminate
        if(depth == nums.length){
            result.add(new ArrayList(path));
            return;
        }

        // process
        for (int i = 0; i < useNums.length; i++) {

            if(!useNums[i]){
                useNums[i] = true;

                path.add(nums[i]);
                DFS(nums,useNums,depth+1,path,result);

                useNums[i] = false;
                path.remove(depth);
            }

        }
    }
}
