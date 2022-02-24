package com.frank.leetcode;

import com.frank.common.LeecodeUtil;
import com.frank.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName LC_82.java
 * @Description TODO
 * @createTime 2022年02月24日 18:00:00
 */
public class LC_82 {
    public static void main(String[] args) {

        ListNode listNode7 =new ListNode(5);
        ListNode listNode6 =new ListNode(4,listNode7);
        ListNode listNode5 =new ListNode(4,listNode6);
        ListNode listNode4 =new ListNode(3,listNode5);
        ListNode listNode3 =new ListNode(3,listNode4);
        ListNode listNode2 =new ListNode(2,listNode3);
        ListNode listNode1 =new ListNode(1,listNode2);

        LC_82 lc = new LC_82();

        ListNode listNode = lc.deleteDuplicates(listNode1);

        LeecodeUtil.printListNode(listNode);

    }


    /**
     * 循环时， 同时比较 curr， next,next.next 的值
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {

        ListNode root = new ListNode(Integer.MIN_VALUE);
        root.next = head;
        ListNode curr = root;
        while (curr != null && curr.next !=null) {

            if (curr.val != curr.next.val) {
                ListNode compareNode = curr.next.next;
                if (compareNode == null) {
                    curr = curr.next;
                    continue;
                } else {
                    if (curr.next.val != compareNode.val) {
                        curr = curr.next;
                        continue;
                    }
                }
            }

            ListNode sameNode  = curr.next;

            while (sameNode != null && sameNode.next != null && sameNode.val == sameNode.next.val) {
                sameNode = sameNode.next;
            }

            if(sameNode == null || sameNode.next ==null){
                curr.next = null;

            }else {
                curr.next = sameNode.next;
            }

        }

        return root.next;
    }

}
