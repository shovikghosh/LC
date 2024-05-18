package utilclasses;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int[] nodeVals) {

    }

//    public TreeNode(int[] nodeVals, TreeNode cur, int idx) {
//        if (idx >= nodeVals.length)
//            return;
//        int curValue = nodeVals[idx];
//        TreeNode left = null;
//        TreeNode right = null;
//        if (curValue != null) {
//
//        }
//    }
}
