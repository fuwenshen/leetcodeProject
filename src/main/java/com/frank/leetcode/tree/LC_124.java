package com.frank.leetcode.tree;


import com.frank.common.TreeNode;

/**
 * . 二叉树中的最大路径和
 */
public class LC_124 {

    int maxResult =  Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxResult;

    }

    /**
     * 后续遍历
     * @param treeNode
     */
    private int dfs(TreeNode treeNode) {

        if (treeNode == null) {
            return 0;
        }

        // 左边的最大值
        int left = Math.max(dfs(treeNode.left), 0);
        // 右边最大值
        int right = Math.max(dfs(treeNode.right), 0);
        // 当前节点最大值
        int maxValue = left + right + treeNode.val;
        // 全部路径最大值
        maxResult = Math.max(maxResult, maxValue);

        return Math.max(left, right) + treeNode.val;
    }




}
