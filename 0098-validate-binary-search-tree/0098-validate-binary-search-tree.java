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
    Integer prev = null;
    int curr = 0;
    boolean answer = true;
    public boolean isValidBST(TreeNode root) {
        traverse(root);
        return answer;
    }

    void traverse(TreeNode node){
        if(node.left!=null) traverse(node.left);
        if(prev==null){
            prev = node.val;
            curr = node.val;
        }else{
            curr = node.val;
            if(prev>=curr){
                answer = false;
                return;
            }else {
                prev = node.val;
            }
        }
        if(node.right!=null) traverse(node.right);
    }
}