package com.frank.leetcode.tree;

import com.frank.common.TreeNode;

public class LC_98 {

    public boolean isValidBST(TreeNode root) {
        return dsf(root);
    }

    Long preValue = Long.MIN_VALUE;
    private boolean dsf(TreeNode treeNode) {

        if(treeNode ==null){
            return true;
        }

        if(!dsf(treeNode.left)){
            return false;
        }

        if(preValue >=treeNode.val){
            return false;
        }
        // 设置前置节点的值
        preValue = Long.valueOf(treeNode.val);

        return dsf(treeNode.right);
    }

}
