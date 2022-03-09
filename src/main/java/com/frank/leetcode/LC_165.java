package com.frank.leetcode;

/**
 *  比较版本号
 */
public class LC_165 {

    public static void main(String[] args) {

        String version1 = "1.0";
        String version2 = "1.0.0";

        LC_165 lc = new LC_165();
        int result = lc.compareVersion(version1, version2);
        System.out.println(result);


    }

    public int compareVersion(String version1, String version2) {

        String[] v1Arr = version1.split("\\.");
        String[] v2Arr = version2.split("\\.");

        int i = 0;
        while (i< v1Arr.length && i < v2Arr.length){

            int v1 = Integer.valueOf(v1Arr[i]);
            int v2 = Integer.valueOf(v2Arr[i]);
            if(v1 >v2){
                return 1;
            }
            if(v1 <v2){
                return -1;
            }
            i++;
        }

        while (i< v1Arr.length) {
            int v = Integer.valueOf(v1Arr[i]);
            if (v > 0) {
                return 1;
            }
            i++;
        }
        while (i< v2Arr.length) {
            int v = Integer.valueOf(v2Arr[i]);
            if (v > 0) {
                return -1;
            }
            i++;
        }

        return 0;

    }
}
