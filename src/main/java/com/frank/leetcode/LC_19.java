package com.frank.leetcode;

import com.frank.common.LeecodeUtil;
import com.frank.common.ListNode;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName LC_19.java
 * @Description 19. 删除链表的倒数第 N 个结点
 * @createTime 2022年02月24日 17:33:00
 */
public class LC_19 {


    public static void main(String[] args) {

        ListNode listNode5 =new ListNode(5);
        ListNode listNode4 =new ListNode(4,listNode5);
        ListNode listNode3 =new ListNode(3,listNode4);
        ListNode listNode2 =new ListNode(2,listNode3);
        ListNode listNode1 =new ListNode(1,listNode2);

        LC_19 lc = new LC_19();

        ListNode listNode = lc.removeNthFromEnd(listNode1, 2);

        LeecodeUtil.printListNode(listNode);

    }
    public ListNode removeNthFromEnd(ListNode head, int n){

        ListNode root = new ListNode();
        root.next = head;
        ListNode fast = root;
        ListNode slow = root;

        while (fast != null) {
            fast = fast.next;
            if (n >= 0) {
                n--;
                continue;
            }
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return root.next;
    }
}
