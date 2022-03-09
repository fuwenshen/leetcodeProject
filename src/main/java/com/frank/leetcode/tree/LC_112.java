package com.frank.leetcode.tree;

import com.frank.common.TreeNode;

/**
 * 112. 路径总和
 */
public class LC_112 {


    public static void main(String[] args) {

//        TreeNode node5 = new TreeNode(5);
//        TreeNode node4 = new TreeNode(4,null,node5);
//        TreeNode node3 = new TreeNode(3,node4,null);
        TreeNode node2 = new TreeNode(2,null,null);
        TreeNode node1 = new TreeNode(1,node2,null);

        LC_112 lc_112 = new LC_112();
        boolean result = lc_112.hasPathSum(node1, 1);
        System.out.println(result);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if(root ==null){
//            return false;
//        }

//        if (!(root.left == null && root.right == null) &&  targetSum == root.val) {
//            return false;
//        }
        return dfs(root,0,targetSum);

    }

    private boolean dfs(TreeNode treeNode, int sum, int targetSum) {

        if (treeNode == null) {
            return false;
        }

        sum = sum + treeNode.val;

        if(treeNode.left == null && treeNode.right == null){
            return sum == targetSum;
        }

        if(dfs(treeNode.left,sum,targetSum)){
           return true;
        }

        return dfs(treeNode.right,sum,targetSum);
    }


}
