package com.frank.leetcode;

import com.frank.common.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName LC_2.java
 * @Description TODO
 * @createTime 2022年02月16日 10:14:00
 */
public class LC_2 {


    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

        ListNode curr =  new ListNode();
        ListNode head =  curr;


        int carryBit = 0;
        while (l1!=null|| l2!=null ) {

            int v1 = l1!=null ? l1.val : 0;
            int v2 = l2!=null ? l2.val : 0;
            int sum = v1 + v2 + carryBit;
            carryBit = sum / 10;

            ListNode result = new ListNode(sum % 10);
            curr.next = result;
            curr = result;


            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }

        }

        if(carryBit >0){
            curr.next = new ListNode(carryBit);;
        }

        return head.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> deque1 = new ArrayDeque<Integer>();
        Deque<Integer> deque2 = new ArrayDeque<Integer>();

        ListNode curr =  new ListNode();
        ListNode head =  curr;

        while (l1!=null){
            deque1.push(l1.val);
            l1 = l1.next;
        }
        while (l2!=null){
            deque2.push(l2.val);
            l2= l2.next;
        }

        int carryBit = 0;
        while (!deque1.isEmpty()|| !deque2.isEmpty() ) {

            int v1 = deque1.peekLast() != null ? deque1.pollLast() : 0;
            int v2 = deque2.peekLast() != null ? deque2.pollLast() : 0;
            int sum = v1 + v2 + carryBit;
            carryBit = sum / 10;

            ListNode result = new ListNode(sum % 10);
            curr.next = result;
            curr = result;
        }

        if(carryBit >0){
            ListNode result = new ListNode(carryBit);
            curr.next = result;
            curr = result;
        }

        return head.next;
    }
}
