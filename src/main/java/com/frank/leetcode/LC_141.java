package com.frank.leetcode;

import com.frank.leetcode.common.ListNode;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName LC_141.java
 * @Description TODO
 * @createTime 2022年01月21日 18:12:00
 */
public class LC_141 {


    public boolean hasCycle(ListNode head) {

        if(head.next == null){
            return false;
        }
        ListNode oneTrip = head.next;
        ListNode twoTrip = head.next;

        while (twoTrip!=null && twoTrip.next!=null ){

            if(oneTrip == twoTrip){
                return  true;
            }
            oneTrip = oneTrip.next;

            twoTrip = twoTrip.next.next;

        }

        return false;

    }

}
