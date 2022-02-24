package com.frank.leetcode;

import com.frank.common.LeecodeUtil;
import com.frank.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName LC_143.java
 * @Description TODO
 * @createTime 2022年02月24日 15:22:00
 */
public class LC_143 {


    public static void main(String[] args) {
        ListNode listNode5 =new ListNode(5);
        ListNode listNode4 =new ListNode(4,listNode5);
        ListNode listNode3 =new ListNode(3,listNode4);
        ListNode listNode2 =new ListNode(2,listNode3);
        ListNode listNode1 =new ListNode(1,listNode2);

        LC_143 lc = new LC_143();

        lc.reorderList(listNode1);

        LeecodeUtil.printListNode(listNode1);


    }





    public void reorderList(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 后半部分翻转
        ListNode secondNode = slow.next;
        slow.next = null;
        ListNode secondHeadNode = reverseListNode(secondNode);


        slow = head;
        fast = secondHeadNode;
        ListNode root = new ListNode();
        ListNode curr = root;
        ListNode q,p;
        while (fast != null) {

            p = slow;
            q = fast;
            slow = slow.next;
            fast = fast.next;


            curr.next = p;
            curr.next.next = q;
            curr = q;
        }

        curr.next = slow;
        head = root.next;

    }


    private ListNode reverseListNode(ListNode listNode){

        ListNode pre = null;
        ListNode curr = listNode;
        ListNode next;
        
        while (curr !=null){

           next = curr.next;

           curr.next = pre;
           pre = curr;
           curr = next;
        }

        return pre;

    }



    /**
     * 使用list存储每个节点、 然后进行重新排序
     * @param head
     */
    public void reorderList1(ListNode head) {

        List<ListNode> list = new ArrayList<>();

        ListNode curr = head;
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }


        ListNode root = new ListNode();
        curr = root;

        int size = list.size();
        int k = 0;
       while (k <= size - 1 - k) {
            curr.next = list.get(k);
            ListNode node = list.get(size - 1 - k);
            curr.next.next = node;
            node.next = null;
            curr = node;
            k++;
        }

        head = root.next;
    }
}
