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
    private boolean answer = true;
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return answer;
    }

    private int maxDepth(TreeNode node){
        if(node==null){
            return 0;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        if(left-right>1 || left-right<-1){
            answer = false;
        }
        return 1+Math.max(left,right);
    }
}