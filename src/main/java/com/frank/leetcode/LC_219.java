package com.frank.leetcode;

import java.util.*;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName LC_219.java
 * @Description 存在重复元素 II
 * @createTime 2022年01月21日 11:40:00
 */
public class LC_219 {


    public static void main(String[] args) {
        LC_219 lc_219 = new LC_219();

        int [] nums = {1,2,3,1,1,2,3};
        int k = 0;

        boolean result = lc_219.containsNearbyDuplicate2(nums, k);

        System.out.println(result);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap();


        for(int i = 0 ; i< nums.length; i++){

            int value = nums[i];
            if(map.get(value) != null){
                Integer j = map.get(value);
                if(i - j <= k){
                    return true;
                }
            }

            map.put(value,i);
        }

        return false;

    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {

        if(k<=0){
            return false;
        }

        ArrayDeque windows = new ArrayDeque(k);

        for(int i = 0 ; i< nums.length; i++){
            int value = nums[i];

            if(windows.contains(value)){
                return true;
            }

            if(windows.size() >= k){
                windows.pollFirst();
            }
            windows.addLast(value);
        }

        return false;

    }


    public boolean containsNearbyDuplicate2(int[] nums, int k) {



        Set<Integer>  windows = new HashSet();

        for(int i = 0 ; i< nums.length; i++){
            int value = nums[i];


            if(windows.size() > k){
                int idx = i-k-1;
                windows.remove(nums[idx]);
            }

            if(!windows.add(value)){
                return true;
            }
        }

        return false;

    }

}
