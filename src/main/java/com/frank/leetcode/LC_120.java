package com.frank.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC_120 {


    public static void main(String[] args) {
        LC_120 lc_120 = new LC_120();
       int [][] triangle =  {{2},{3,4},{6,5,7},{4,1,8,3}};


//
//        List<List[]> asList = Arrays.asList(triangle);
//        lc_120.minimumTotal(asList);

    }


    public int minimumTotal(List<List<Integer>> triangle) {

        int len = triangle.size();

        List<Integer>  minResultList = new ArrayList(triangle.get(len-1));

        for (int i = len-2; i >=0; i--) {

            for (int j = 0; j < triangle.get(i).size(); j++) {

                int min = triangle.get(i).get(j) + Math.min( minResultList.get(j), minResultList.get(j+1));
                minResultList.set(j,min);
            }
        }
        return  minResultList.get(0);
    }
}
