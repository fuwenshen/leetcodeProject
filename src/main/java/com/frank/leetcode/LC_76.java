package com.frank.leetcode;

import java.util.HashMap;

public class LC_76 {


    public static void main(String[] args) {


        String s = "abacabc", t = "abc";
        LC_76 lc = new LC_76();

        String res = lc.minWindow(s, t);
        System.out.println(res);

    }

    public String minWindow(String s, String t) {

        HashMap<Character,Integer> map = new HashMap();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(map.get(c)!=null){
                map.put(c,map.get(c)+1);
            }else {
                map.put(c,1);
            }
        }


        int count = t.length();
        int minLen = Integer.MAX_VALUE;
        int a=0,b=-1;
        int i = -1,j= -1;
       while (i <j ||j <s.length()-1){
           if(count>0 && j <s.length()-1) {
               j++;
               char at = s.charAt(j);
               if (map.containsKey(at)) {
                   Integer integer = map.get(at);
                   map.put(at, integer - 1);

                   if (integer > 0) {
                       count--;
                   }
               }

           }else {
               // 結束
               if (count >0 && j >=s.length()-1){
                   break;
               }


               i++;
               if(minLen > (j-i)){
                   minLen = j-i+1;
                   a = i;
                   b = j;
               }

               char at = s.charAt(i);
               if(map.containsKey(at)){
                   Integer integer = map.get(at);
                   map.put(at,integer+1);
                   if(integer>=0){
                       count++;
                   }
               }

           }
       }

       return s.substring(a,b+1);

    }
}
