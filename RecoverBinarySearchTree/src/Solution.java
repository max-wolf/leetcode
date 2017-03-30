
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    TreeNode p, q, pre;
    public void recoverTree(TreeNode root) {
        p = null;
        q = null;
        pre = null;
        travseral(root);
        if(p != null && q != null) {
            int tmp = p.val;
            p.val = q.val;
            q.val = tmp;
        }
    }
    void travseral(TreeNode root) {
        if(root == null) return;
        if(root.left != null) travseral(root.left);
        if(pre != null && pre.val > root.val) {
            if(p == null) p = pre;
            q = root;
        }
        pre = root;
        if(root.right != null) travseral(root.right);
    }
}
