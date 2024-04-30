package binarytreeinordertraversal;

import utilclasses.TreeNode;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> path = new LinkedList<>();
        traverse(root, path);
        return path;
    }

    private void traverse(TreeNode root, List<Integer> path) {
        if(root == null)
            return;
        traverse(root.left, path);
        path.add(root.val);
        traverse(root.right, path);
    }
}
