package com.frank.leetcode;

import com.frank.leetcode.common.ListNode;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName LC24.java
 * @Description TODO
 * @createTime 2022年01月20日 14:49:00
 */
public class LC_24 {


    public static void main(String[] args) {
        LC_24 leeCode = new LC_24();
//        ListNode listNode4 =new ListNode(4);
        ListNode listNode3 =new ListNode(3);
        ListNode listNode2 =new ListNode(2,listNode3);
        ListNode listNode1 =new ListNode(1,listNode2);

        ListNode listNode = leeCode.swapPairs1(listNode1);
        printListNode(listNode);
    }



    public ListNode swapPairs(ListNode head) {

        ListNode headNode = new ListNode();
        headNode.next = head;

        ListNode pre = headNode;
        ListNode  curr = head;

        while (curr !=null ){
            ListNode next = curr.next;
            if(next == null){
                pre.next =curr;
                break;
            }

            ListNode nextNode = next.next;

            // 1-2 -> 2-1     交换链表
            pre.next = next;
            next.next = curr;
            curr.next = null;

            // 新的一轮赋值
            pre = curr;
            curr = nextNode;
        }

        return headNode.next;
    }


    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {

        if(head==null || head.next == null){
            return  head;
        }

        ListNode next = head.next;

        head.next = swapPairs1(head.next.next);

        next.next = head;

        return next;
    }


    public static void printListNode(ListNode listNode){
        ListNode curNode = listNode;
        System.out.println("result:");
        while (curNode!=null){
            System.out.print(curNode.val+",");
            curNode = curNode.next;
        }
        System.out.println("\n---------------------");
    }
}
