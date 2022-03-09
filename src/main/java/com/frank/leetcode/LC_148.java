package com.frank.leetcode;

import com.frank.common.LeecodeUtil;
import com.frank.common.ListNode;

import java.util.*;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName LC_148.java
 * @Description 148. 排序链表
 * @createTime 2022年02月25日 10:49:00
 */
public class LC_148 {

    public static void main(String[] args) {
        ListNode listNode6 =new ListNode(3);
        ListNode listNode5 =new ListNode(3,listNode6);
        ListNode listNode4 =new ListNode(4,listNode5);
        ListNode listNode3 =new ListNode(5,listNode4);
        ListNode listNode2 =new ListNode(1,listNode3);
        ListNode listNode1 =new ListNode(2,listNode2);

        LC_148 lc_148 = new LC_148();
        ListNode sortListNode = lc_148.sortList(listNode1);
        LeecodeUtil.printListNode(sortListNode);

    }

    public ListNode sortList1(ListNode head) {


        TreeSet treeSet = new TreeSet((Comparator<ListNode>) (o1, o2) -> o1.val - o2.val);


        ListNode curr = head;
        while (curr!=null){
            treeSet.add(curr);
            curr = curr.next;
        }


        Iterator<ListNode> iterator = treeSet.iterator();

        ListNode root = new ListNode();
        curr = root;
        while (iterator.hasNext()){
            ListNode next = iterator.next();
            curr.next = next;
            curr = next;
        }

        curr.next = null;

        return root.next;
    }


    public ListNode sortList(ListNode head) {

        Map<Integer,ListNode> sortMap = new TreeMap();

        ListNode curr = head;
        while(curr !=null){
            int value = curr.val;
            ListNode next = curr.next;
            curr.next = null;
            if(sortMap.get(value)!=null){
                ListNode node = sortMap.get(value);
                while (node.next!=null){
                    node = node.next;
                }
                node.next = curr;
            }else{
                sortMap.put(value,curr);
            }
            curr = next;
        }

        ListNode sortNode = new ListNode();
        curr = sortNode;
        for (Map.Entry<Integer,ListNode> entry:sortMap.entrySet()) {


            curr.next = entry.getValue();

            while (curr.next!=null){
                curr = curr.next;
            }
        }

        return sortNode.next;
    }


}
