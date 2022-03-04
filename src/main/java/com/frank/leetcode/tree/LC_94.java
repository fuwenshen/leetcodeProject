package com.frank.leetcode.tree;

import com.frank.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *  二叉树的中序遍历
 */
public class LC_94 {


    public static void main(String[] args) {

        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1,node2,node3);

        LC_94 lc_94 = new LC_94();
        lc_94.inorderTraversal(node1);

    }


    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

//        inTraversal(root,result);

        if(root == null){
            return result;
        }
        Stack<TreeNode>  stack = new Stack<>();
        stack.push(root);

        TreeNode curr = root;
        while (!stack.isEmpty() ) {
            // 先将左子树插入到栈中
            while (curr.left != null) {
                stack.push(curr.left);
                curr = curr.left;
            }

            // 获取当前节点的val
            TreeNode node = stack.pop();
            //System.out.println(node.val);
            result.add(node.val);

            // 遍历右子树， 将右子树存入栈中
            if (node.right != null) {
                stack.push(node.right);
                curr = node.right;
            }
        }

        return result;
    }






    /**
     * 递归遍历
     * @param treeNode
     * @param result
     */
    private void  inTraversal(TreeNode treeNode,List<Integer> result){
        if(treeNode == null){
            return;
        }
        inTraversal(treeNode.left,result);

        result.add(treeNode.val);

        inTraversal(treeNode.right,result);
    }



}
