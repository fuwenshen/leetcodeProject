package com.frank.leetcode.tree;

import com.frank.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *  二叉树的前序遍历
 */
public class LC_144 {




    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        preTraversal(root,result);

        return result;
    }


    /**
     * 递归遍历
     * @param treeNode
     * @param result
     */
    private void  preTraversal(TreeNode treeNode,List<Integer> result){
        if(treeNode == null){
            return;
        }
        result.add(treeNode.val);

        preTraversal(treeNode.left,result);
        preTraversal(treeNode.right,result);
    }



}
