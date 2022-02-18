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


    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);

        // 缓存是 {1=1}
        lRUCache.put(1, 1);
        // 缓存是 {1=1, 2=2}
        lRUCache.put(2, 2);
        // 返回 1
        lRUCache.get(1);
        // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.put(3, 3);
        // 返回 -1 (未找到)
        lRUCache.get(2);
        // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.put(4, 4);
        // 返回 -1 (未找到)
        lRUCache.get(1);
        // 返回 3
        lRUCache.get(3);
        // 返回 4
        lRUCache.get(4);

    }

    Map<Integer, Node<Integer,Integer>> keyMap = new HashMap();
    Node<Integer,Integer> head,tail;
    int capacity;
    int count;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre =head;
        count = 0;
    }

    public int get(int key) {

        if(!keyMap.containsKey(key)){
            return -1;
        }

        Node<Integer,Integer> listNode = keyMap.get(key);
        int value = listNode.value;

        listNode.pre.next = listNode.next;
        listNode.next.pre = listNode.pre;
        // 换到最前面去
        putNodeToFirst(listNode);

        System.out.println("getValue "+value);
        return value;
    }

    public void put(int key, int value) {

        System.out.println("put:"+key +" "+value);

        if(capacity <=0){
            return;
        }

        // 1. 判断是否存在
        if(keyMap.containsKey(key)){
            Node listNode = keyMap.get(key);

            // 维护节点关系
            listNode.pre.next = listNode.next;
            listNode.next.pre = listNode.pre;

            // 当前节点移到最前面
            listNode.value = value;
            putNodeToFirst(listNode);
            return;
        }


        // 不存在， 查看容器是否满了,未满，可以存放新数据
        if(count>=capacity) {
            // 移除最后的元素
            removeLast();

        }

        // 插入新元素
        Node<Integer,Integer> node = new Node(key,value);
        putNodeToFirst(node);

        count ++;
        keyMap.put(key,node);
        return;
    }


    private void putNodeToFirst(Node node){
        node.next = head.next;
        head.next.pre = node;

        head.next = node;
        node.pre = head;
    }

    private void removeLast(){
        Node lastNode = tail.pre;

        lastNode.pre.next = tail;
        tail.pre = lastNode.pre;
        keyMap.remove(lastNode.key);
        count--;

        lastNode = null;
    }




    class Node<K,V>{
        public Node(){
        }
        public Node(K key,V value){
            this.key = key;
            this.value = value;
        }
        K key;
        V value;
        Node pre;
        Node next;

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", pre.value=" + ( pre==null? "null": pre.value )+
                    ", next.value=" + ( next==null? "null": next.value )+
                    '}';
        }
    }
}
