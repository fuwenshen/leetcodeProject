package com.frank.leetcode.tree;

import com.frank.common.TreeNode;

import java.util.*;

/**
 * . 二叉树的锯齿形层序遍历
 */
public class LC_103 {

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3,node6,node7);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node1 = new TreeNode(1,node2,node3);

        LC_103 LC_103 = new LC_103();
        LC_103.zigzagLevelOrder(node1);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {


        List<List<Integer>> result = new ArrayList<>();


        if(root ==null){
            return result;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        int k =1;
        while (!queue.isEmpty()) {

            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> childQueue = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                if ((k & 1) == 1) {
                    TreeNode remove = queue.poll();
                    System.out.println(remove.val);
                    res.add(remove.val);
                    if (remove.left != null) {
                        childQueue.add(remove.left);
                    }
                    if (remove.right != null) {
                        childQueue.add(remove.right);
                    }
                }else {
                    TreeNode remove = queue.pollLast();
                    System.out.println(remove.val);
                    res.add(remove.val);
                    if (remove.right != null) {
                        childQueue.addFirst(remove.right);
                    }
                    if (remove.left != null) {
                        childQueue.addFirst(remove.left);
                    }
                }

            }
            result.add(res);
            queue.addAll(childQueue);
            k++;
        }

        return result;
    }
}
