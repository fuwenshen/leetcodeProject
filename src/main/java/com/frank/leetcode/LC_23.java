package com.frank.leetcode;

import com.frank.common.LeecodeUtil;
import com.frank.common.ListNode;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName LC_23.java
 * @Description 23. 合并K个升序链表
 * @createTime 2022年02月23日 16:38:00
 */
public class LC_23 {


    public static void main(String[] args) {

        ListNode listNode5 =new ListNode(5);
        ListNode listNode4 =new ListNode(4,listNode5);
        ListNode listNode3 =new ListNode(3,listNode4);
        ListNode listNode2 =new ListNode(2,listNode3);
        ListNode listNode1 =new ListNode(1,listNode2);


        ListNode listNode15 =new ListNode(5);
        ListNode listNode14 =new ListNode(3,listNode15);
        ListNode listNode13 =new ListNode(3,listNode14);
        ListNode listNode12 =new ListNode(1,listNode13);
        ListNode listNode11 =new ListNode(0,listNode12);

        LC_23 lc = new LC_23();

        ListNode[] lists = {listNode1,listNode11};

        ListNode result = lc.mergeKLists(lists);

        LeecodeUtil.printListNode(result);
    }


    /**
     * 冒泡合并
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode root = new ListNode(0);
        ListNode curr =root;

        if(lists == null || lists.length ==0){
            return root.next;
        }

        while (true){

            int minIndex = 0;
            Integer minValue = null;
            for (int i = 0; i < lists.length; i++) {
                ListNode list = lists[i];
                if(list == null){
                    continue;
                }

                if(minValue == null){
                    minValue = list.val;
                    minIndex = i;
                    continue;
                }
                
                if(list.val <= minValue){
                    minValue = list.val;
                    minIndex = i;
                }
            }

            ListNode minNode = lists[minIndex];

            if(minNode == null){
                break;
            }
            lists[minIndex] = minNode.next;

            curr.next = minNode;
            curr = minNode;
        }

        return root.next;
    }
}
