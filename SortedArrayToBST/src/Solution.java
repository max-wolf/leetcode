
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int left, int right) {
        if(left > right) return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTree(nums, left, mid-1);
        node.right = buildTree(nums, mid+1, right);
        return node;
    }
}
