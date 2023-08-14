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
    private List<Integer> answerList = new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        TreeNode newRoot = new TreeNode(answerList.get(0));
        TreeNode node = newRoot;
        for(int i=1; i<answerList.size();i++){
            node.right = new TreeNode(answerList.get(i));
            node = node.right;
        }
        return newRoot;
        
    }
    
    void inorder(TreeNode node){
        if(node.left!=null) inorder(node.left);
        answerList.add(node.val);
        if(node.right!=null) inorder(node.right);
    }
}