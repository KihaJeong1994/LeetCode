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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root.val==val){
            return root;
        }
        if(root.left!=null){
            TreeNode leftSearch = searchBST(root.left,val);  
            if(leftSearch!=null) return leftSearch;
        } 
        if(root.right!=null){
            TreeNode rightSearch = searchBST(root.right,val);  
            if(rightSearch!=null) return rightSearch;
        } 
        return null;
    }
}