package com.frank.sort;


import java.util.Random;

/**
 * 快速排序
 */
public class QuicklySort {

    public static void main(String[] args) {

        QuicklySort quicklySort = new QuicklySort();


        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        quicklySort.quicklySort(nums, 0, nums.length - 1);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }

    }


    public void quicklySort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        System.out.println("***");

        int randomIndex = new Random().nextInt(right - left)+left;
        int pivot = nums[randomIndex];
        nums[randomIndex] = nums[left];
        int l = left, r = right;

        while (l < r) {
            while (l < r && nums[r] > pivot) {
                r--;
            }
            if (l < r) {
                nums[left++] = nums[r];
            }

            while (l < r && nums[l] < pivot) {
                l++;
            }
            if (l < r) {
                nums[r--] = nums[l];
            }

        }
        nums[l] = pivot;


        quicklySort(nums, left, l - 1);
        quicklySort(nums, l + 1, right);


    }


    /**
     * 使用第一个做槽位
     *
     * @param num
     * @param left
     * @param right
     */
    public void quicklySort1(int[] num, int left, int right) {

        if (left >= right) {
            return;
        }
        System.out.println("***");

        int l = left, r = right;

        int pivot = num[l];

        while (l < r) {

            while (l < r && num[r] > pivot) {
                r--;
            }
            if (l < r) {
                num[l++] = num[r];
            }

            while (l < r && num[l] < pivot) {
                l++;
            }
            if (l < r) {
                num[r--] = num[l];
            }

            num[l] = pivot;
        }


        //
        quicklySort1(num, left, l - 1);
        quicklySort1(num, l + 1, right);
    }

}
