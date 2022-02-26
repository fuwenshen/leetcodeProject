package com.frank.leetcode;

import com.frank.common.ListNode;

import java.util.*;

public class LC_138 {

    public static void main(String[] args) {


//        ListNode listNode5 =new ListNode(5);
//        ListNode listNode4 =new ListNode(4,listNode5);
//        ListNode listNode3 =new ListNode(3,listNode4);
        Node node2 =new Node(2);
        Node node1 =new Node(1);

        node1.next = node2;
        node2.next = null;
        node1.random = node2;
        node2.random = node2;

        LC_138 lc_138 = new LC_138();

        Node node = lc_138.copyRandomList(node1);

    }

    public Node copyRandomList(Node head) {

        Map<Node,Integer> linkedHashMap = new LinkedHashMap<>();
        List<Node> copyNodes = new ArrayList<>();


        Node root = new Node(0);
        Node copyCurr = root;

        Node curr = head;
        int index = 0;
        while (curr !=null){
            linkedHashMap.put(curr,index);
            Node node = new Node(curr.val);
            copyNodes.add(node);
            copyCurr.next = node;
            copyCurr = node;

            curr = curr.next;
            index ++;
        }

        index = 0;
        for (Node node : linkedHashMap.keySet()) {
            if(node.random !=null){
                Integer randomIdx = linkedHashMap.get(node.random);
                // 赋值 random
                copyNodes.get(index).random = copyNodes.get(randomIdx);
            }
            index ++;
        }

       return root.next;
    }
}






// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
