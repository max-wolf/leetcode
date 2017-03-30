
import java.util.*;
import java.lang.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> val = new ArrayList<List<Integer>>();
        if(root == null) return val;
        List<Integer> tmp = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int num;
        boolean reverse = false;
        while (!queue.isEmpty()) {
            tmp.clear();
            num = queue.size();
            for(int i = 0; i < num; i++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            if(reverse) {
                Collections.reverse(tmp);
                reverse = false;
            } else {
                reverse = true;
            }
            val.add(new ArrayList<>(tmp));
        }
        return val;
    }
}
