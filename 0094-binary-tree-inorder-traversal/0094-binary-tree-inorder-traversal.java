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
    List<Integer> answer = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root!=null)traverse(root);
        return answer;
    }

    void traverse(TreeNode node){
        if(node.left != null)traverse(node.left);
        answer.add(node.val);
        if(node.right!=null)traverse(node.right);
    }
}