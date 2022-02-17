package com.frank.common;

/**
 * @author fuwenshen
 * @version 1.0.0
 * @ClassName LeecodeUtil.java
 * @Description TODO
 * @createTime 2022年01月24日 14:09:00
 */
public class LeecodeUtil {




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
