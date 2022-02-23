package com.frank.leetcode;

import com.frank.common.LeecodeUtil;
import com.frank.common.ListNode;

import java.util.List;

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

        ListNode root = new ListNode();
        root.next = head;

        ListNode pre = root, next = null;
        ListNode curr = head;

        int index = 1;

        while (curr != null) {
            if (index < left) {
                pre = curr;
            }

            if (index == right) {
                next = curr.next;
                curr.next = null;
                break;
            }
            curr = curr.next;
            index++;
        }

        ListNode reverseNode = pre.next;
        pre.next = reverseListNode(reverseNode);

        reverseNode.next = next;
        return root.next;
    }



    public ListNode reverseListNode(ListNode listNode){
        ListNode pre = null;
        ListNode curr = listNode;
        ListNode next;


        while (curr !=null){
            next =  curr.next;
            // 翻转节点
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }


}
