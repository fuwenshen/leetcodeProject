package com.frank.leetcode.tree;

import com.frank.common.TreeNode;

import java.util.*;

/**
 * 二叉树的层序遍历
 */
public class LC_102 {

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1,node2,node3);

        LC_102 lC_102 = new LC_102();
        lC_102.levelOrder(node1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {


        List<List<Integer>> result = new ArrayList<>();


        if(root ==null){
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque();

        queue.add(root);

        while (!queue.isEmpty()){

            List<Integer> res = new ArrayList<>();
            List<TreeNode> childList = new ArrayList<>();
            while (!queue.isEmpty()){
                TreeNode remove = queue.poll();
                System.out.println(remove.val);
                res.add(remove.val);
                if(remove.left != null){
                    childList.add(remove.left);
                }
                if(remove.right != null){
                    childList.add(remove.right);
                }
            }
            result.add(res);
            queue.addAll(childList);
        }

        return result;
    }
}
