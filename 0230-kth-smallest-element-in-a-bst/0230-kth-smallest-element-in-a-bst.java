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
    int num = 0;
    int answer=0;
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root,k);
        return answer;
    }

    private void inOrder(TreeNode node, int k){
        if(node.left!=null)inOrder(node.left,k);
        num++;
        if(num == k) answer = node.val;
        if(node.right!=null)inOrder(node.right,k);
    }
}