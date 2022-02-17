package com.frank.leetcode;

import com.frank.common.LeecodeUtil;
import com.frank.common.ListNode;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName LC_92.java
 * @Description 反转链表 II
 * @createTime 2022年01月24日 11:43:00
 */
public class LC_92 {


    public static void main(String[] args) {
        LC_92 leeCode = new LC_92();
//        ListNode listNode5 =new ListNode(5);
//        ListNode listNode4 =new ListNode(4,listNode5);
//        ListNode listNode3 =new ListNode(3,listNode4);
        ListNode listNode2 =new ListNode(2);
        ListNode listNode1 =new ListNode(1,listNode2);


        ListNode node = leeCode.reverseBetween(listNode1, 1, 2);


        LeecodeUtil.printListNode(node);
    }


    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null){
            return  head;
        }


        ListNode root = new ListNode(0);

        ListNode startTag  = root;


        for (int i = 1; i <= left ; i++) {
            startTag = startTag.next;
        }


        head = startTag.next;


        for (int i = left; i <= right ; i++) {




        }

        ListNode curNode  = head;
        ListNode nextNode = head;
        ListNode endTag = null;
        ListNode preTag = null;



        ListNode preNode = null;

        int index = 1;
        // 1->2->3->4->5
        // 1->4->3->2->5
        while (index < left && curNode != null){
            index ++;
            preTag = curNode;
            curNode = curNode.next;
        }

        startTag  = curNode;

        while (curNode!=null){

            nextNode = curNode.next;

            curNode.next = preNode;

            if(index >=right){
                endTag = nextNode;
                break;
            }

            preNode = curNode;
            curNode = nextNode;
            index ++;
        }


        preTag.next = curNode;

        startTag.next = endTag;
        return  head;
    }
}
