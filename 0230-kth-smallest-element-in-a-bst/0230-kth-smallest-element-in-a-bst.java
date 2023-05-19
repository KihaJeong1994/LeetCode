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
    int order;
    int globalAnswer, globalK;
    boolean finished;
    public int kthSmallest(TreeNode root, int k) {
        globalK= k;
        traverse(root);
        return globalAnswer;
    }

    private void traverse(TreeNode node) {
        if (node.left != null && !finished) traverse(node.left);
        if(!finished){
            order++;
            if (order == globalK) {
                globalAnswer = node.val;
                finished = true;
                return;
            }
        }
        if (node.right != null && !finished) traverse(node.right);
    }
}