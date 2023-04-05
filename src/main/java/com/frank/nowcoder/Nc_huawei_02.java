package com.frank.nowcoder;


import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 明明生成了N个1到500之间的随机整数。请你删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。
 *
 * 数据范围：  ，输入的数字大小满足
 */
public class Nc_huawei_02 {


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }


        Integer[] res = deleteRepNum(nums);

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }


    }


    public static Integer[] deleteRepNum(int[] nums){

        Set<Integer> set = new TreeSet();

        for (int i = 0; i < nums.length; i++) {

            int value = nums[i];
            if(set.contains(value)){
                continue;
            }
            set.add(value);
        }


        Integer[] arr = new Integer[set.size()];
        set.toArray(arr);

        return arr;

    }


}
