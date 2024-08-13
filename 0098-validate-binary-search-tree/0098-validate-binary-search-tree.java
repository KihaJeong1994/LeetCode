/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.valueOf(Integer.MIN_VALUE)-1, Long.valueOf(Integer.MAX_VALUE)+1);
    }

    private boolean dfs(TreeNode root, long minVal, long maxVal){
        if(root==null) return true;
        if(Long.valueOf(root.val)<=minVal || Long.valueOf(root.val)>=maxVal) return false;
        boolean left = dfs(root.left, minVal, Math.min(maxVal, Long.valueOf(root.val)));
        boolean right = dfs(root.right, Math.max(minVal, Long.valueOf(root.val)), maxVal);
        return left && right;
    }
}