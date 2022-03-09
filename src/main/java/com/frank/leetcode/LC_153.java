package com.frank.leetcode;

public class LC_153 {


    public static void main(String[] args) {

        int[] nums = {2,3,1};
        LC_153 lc_153 = new LC_153();
        int min = lc_153.findMin(nums);

        System.out.println(min);
    }


    int findMin(int[]nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }


    public int findMin1(int[] nums) {


        int len = nums.length;

        if(len ==1){
            return nums[0];
        }
        if(len ==2){
            return Math.min(nums[0],nums[1]);
        }

        int l = 0;
        int r = len - 1;
        int middle = 0;

        while (l <= r) {

            middle = l + (r - l) / 2;

            // 整体有序
            if (nums[l] < nums[middle] && nums[middle] < nums[r]) {
                middle = l;
                break;
            }
            // 找到最小值
            if (nums[(middle - 1 + len) % len] > nums[middle] && nums[(middle + 1) % len] > nums[middle]) {
                break;
            }

            // 左边大于中间， 往左边缩
            if (nums[l] > nums[middle]) {
                r = middle == r ? middle - 1 : middle;
            }

            // 右边小于中间，往右边靠
            if (nums[middle] > nums[r]) {
                l = middle == l ? middle + 1 : middle;
            }

        }


        return nums[middle];

    }


}
