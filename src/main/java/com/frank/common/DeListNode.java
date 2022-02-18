package com.frank.common;

public class DeListNode extends ListNode {

    public ListNode pre;
    public ListNode next;
    public DeListNode() {}
    public DeListNode(int val) { this.val = val; }
    public DeListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
