/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode answer;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        dfs(original, cloned , target);
        return answer;
    }

    void dfs(TreeNode node, TreeNode clone, TreeNode target){
        if(node == target){
            answer = clone;
            return;
        }
        if(node.left!=null) dfs(node.left,clone.left, target);
        if(node.right!=null) dfs(node.right,clone.right, target);
    }
}