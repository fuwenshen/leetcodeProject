package com.frank.leetcode;

import com.frank.leetcode.common.ListNode;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName LC_160.java
 * @Description TODO
 * @createTime 2022年01月21日 10:49:00
 */
public class LC_160 {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode nodeA = headA;
        ListNode nodeB = headB;


        while (nodeA != nodeB) {

            nodeA = nodeA!=null? nodeA.next : headB;

            nodeB = nodeB!=null? nodeB.next : headA;
        }
        return nodeA;
    }
}
