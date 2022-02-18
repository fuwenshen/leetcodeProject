package com.frank.leetcode;

import com.frank.common.DeListNode;
import com.frank.common.ListNode;
import org.w3c.dom.Node;

import java.util.*;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。

 */
public class LRUCache {



    Map<Integer, DeListNode> keyMap = new HashMap();

    DeListNode head,tail;

    int capacity;

    int count;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        DeListNode head =new DeListNode();
        DeListNode tail = head;
        count = 0 ;
    }

    public int get(int key) {

        if(!keyMap.containsKey(key)){
            return -1;
        }


        DeListNode listNode = keyMap.get(key);
        int value = listNode.val;

        listNode.pre.next = listNode.next;
        // 换到最前面去
        ListNode first = head.next;
        listNode.next  = first;
        head.next = listNode;
        return value;
    }

    public void put(int key, int value) {

        // 可以存放新数据
        if(count<capacity){





        }


    }
}
