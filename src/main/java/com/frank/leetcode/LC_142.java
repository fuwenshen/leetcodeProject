package com.frank.leetcode;

import com.frank.common.ListNode;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName LC_142.java
 * @Description 环形链表 II
 * @createTime 2022年02月23日 17:59:00
 */
public class LC_142 {


    /**
     *  f为快指针的走的节点数量，s为慢节点。。。
     *  假设起点到进环的节点数为a,  环内的节点数为b；
     * 1. f = 2s；
     * 2. f = s + nb
     * 结合1，2 得： s = nb;
     *
     * 入环口的位置所走的节点数：a+nb;
     * 而第一次相遇时，慢指针走路径为 nb；所以s只要在走a个节点，既可到达第一个入环节点；
     * 此时重新从链表从头开始走，走a个节点正好到达入库，正好他们第二次相遇;
     *
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slowNode = head;
        ListNode fastNode = head;

        boolean isCycle = false;
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (fastNode == slowNode) {
                isCycle = true;
                break;
            }
        }

        if (isCycle) {
            fastNode = head;
            while (true) {
                if (fastNode == slowNode) {
                    return slowNode;
                }
                fastNode = fastNode.next;
                slowNode = slowNode.next;
            }
        }

        return null;
    }
}
