package com.frank.leetcode;


import java.util.Arrays;

/**
 *  最长公共前缀
 */
public class LC_14 {


    public static void main(String[] args) {

        String[] strs  = {"flower","flow","flight"};
     //   String[] strs  = {"ab","a"};

        LC_14 lc = new LC_14();

        String prefix = lc.longestCommonPrefix(strs);

        System.out.println(prefix);
    }



    public String longestCommonPrefix(String[] strs) {

        if(strs==null || strs.length==0){
            return "";
        }

        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            String str = strs[i];
            while (j<str.length() && j<res.length()){
                if(str.charAt(j) != res.charAt(j)){
                    break;
                }
                j++;
            }
            res = res.substring(0,j);
        }

        return res;

    }

    public String longestCommonPrefix1(String[] strs) {

        if(strs==null || strs.length==0){
            return "";
        }

        int index = 0;
        char a = 0;
        StringBuilder res = new StringBuilder();
        while (true){
            for (int i = 0; i < strs.length; i++) {
                String str = strs[i];
                if(index >= str.length()){
                    return res.toString();
                }
                if(i == 0){
                    a = str.charAt(index);
                }
                if(a!= str.charAt(index)){
                    return res.toString();
                }
            }
            res.append(a);
            index ++;
        }
    }
}
