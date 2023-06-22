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
    private int max;
    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }
    
    private void traverse(TreeNode node){
        if(node.right!=null){
            traverse(node.right);
        }
        max+=node.val;
        node.val = max;
        if(node.left!=null){
            traverse(node.left);
        }
    }
}