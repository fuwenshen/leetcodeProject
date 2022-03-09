package com.frank.leetcode.tree;

import com.frank.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_199 {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList();

        queue.offer(root);


        while (!queue.isEmpty()) {

            int count = queue.size();

            while (count > 0) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (count == 1) {
                    result.add(node.val);
                }
                count --;
            }
        }
        return result;

    }
}
