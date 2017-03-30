
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {     //time exceed
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int n = 0;
        while(!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            n++;
            if(tmp.left != null) {
                queue.add(tmp.left);
            }
            if(tmp.right != null) {
                queue.add(tmp.right);
            }
        }
        return n;
    }
    public int countNodes1(TreeNode root) {
        if(root == null) return 0;
        int left = getLeft(root) + 1;
        int right = getRight(root) + 1;
        if(left == right) {
            //return (int)Math.pow(2, left) - 1;
            return (2<<(left-1)) - 1;
        }
        else {
            return countNodes1(root.left) + countNodes1(root.right) + 1;
        }
    }
    public int getLeft(TreeNode root) {
        int n = 0;
        while (root.left != null) {
            root = root.left;
            n++;
        }
        return n;
    }
    public int getRight(TreeNode root) {
        int n = 0;
        while (root.right != null) {
            root = root.right;
            n++;
        }
        return n;
    }
}
