package com.frank.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName LC125.java
 * @Description T215. 数组中的第K个最大元素
 * @createTime 2022年01月20日 18:25:00
 */
public class LC_125 {

    public static void main(String[] args) {
        LC_125 leetcode = new LC_125();
        int [] nums ={3,2,3,1,2,4,5,5,6};

        int k = 4;
        int result = leetcode.findKthLargest1(nums, k);

        System.out.println(result);

    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length-k];
    }


    public int findKthLargest1(int[] nums, int k) {


        PriorityQueue<Integer> minHeap = new PriorityQueue(k);

        for (int i = 0; i < nums.length; i++) {


            if(minHeap.size()<k){
                minHeap.add(nums[i]);
            }else if(nums[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }

        return minHeap.peek();
    }
}
