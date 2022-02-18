package com.frank.common;

public class DeListNode{

    public int val;
    public DeListNode pre;
    public DeListNode next;
    public DeListNode() {}
    public DeListNode(int val) { this.val = val; }
    public DeListNode(int val, DeListNode next) { this.val = val; this.next = next; }


    @Override
    public String toString() {
        return "DeListNode{" +
                "val=" + val +
                ", pre.val=" + ( pre==null? "null": pre.val )+
                ", next.val=" + ( next==null? "null": next.val )+
                '}';
    }

}
