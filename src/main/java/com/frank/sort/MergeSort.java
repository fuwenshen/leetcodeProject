package com.frank.sort;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName MergeSort.java
 * @Description  归并排序  O(nlogn)  O（n）
 * @createTime 2022年03月24日 12:27:00
 */
public class MergeSort {

    public static void main(String[] args) {

        MergeSort mergeSort = new MergeSort();


//        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] nums = {7, 2, 5, 4, 8, 6, 1};
        mergeSort.distribute(nums, 0, nums.length - 1);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }

    }


    public void distribute(int[] num, int left, int right) {
        //terminate
        if (left >= right) {
            return;
        }

        int center = left + (right - left) / 2;
        // logic

        //进行数据分发
        distribute(num, left, center);
        distribute(num, center + 1, right);

        // 合并分发后的数据
        mergeSort(num, left, center, right);

    }

    // 合并数据
    private void mergeSort(int[] num, int left, int center, int right) {


        int[] sortNum = new int[right - left+1];

        int index = 0;
        int i = left, j = center+1;
        while (i <= center && j <= right) {
            sortNum[index++] = num[i] <= num[j] ? num[i++] : num[j++];
        }


        while (i <= center) {
            sortNum[index++] = num[i++];
        }

        while (j <= right) {
            sortNum[index++] = num[j++];
        }


        for (int k = 0; k < sortNum.length; k++) {
            num[left + k] = sortNum[k];
        }
        sortNum = num;
    }
}
