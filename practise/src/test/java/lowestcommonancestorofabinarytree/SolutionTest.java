package lowestcommonancestorofabinarytree;

import org.junit.jupiter.api.Test;
import utilclasses.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void lowestCommonAncestor() {
        // root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
        TreeNode p, q;

        TreeNode left = new TreeNode(7);
        TreeNode right = new TreeNode(4);
        right = new TreeNode(2, left, right);
        left = new TreeNode(6);
        left = new TreeNode(5, left, right);
        p = left;

        TreeNode root = new TreeNode(3);
        root.left = left;

        left = new TreeNode(0);
        right = new TreeNode(8);
        right = new TreeNode(1, left, right);
        q = right;
        root.right = right;

        Solution s = new Solution();

        assertEquals(s.lowestCommonAncestor(root, p, q).val, root.val);
    }
}
