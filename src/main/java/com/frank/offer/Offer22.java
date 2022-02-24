package com.frank.offer;

import com.frank.common.ListNode;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName Offer22.java
 * @Description 剑指 Offer 22. 链表中倒数第k个节点
 * @createTime 2022年02月24日 17:19:00
 */
public class Offer22 {

    public ListNode getKthFromEnd(ListNode head, int k) {


        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            fast = fast.next;
            if (--k >= 0) {
                continue;
            }

            slow = slow.next;
        }


        return slow;

    }
}
