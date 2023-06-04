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
    private int maxDepth;
    private int answer;
    public int deepestLeavesSum(TreeNode root) {
        searchNode(root,0);
        return answer;
    }
    
    private void searchNode(TreeNode node, int depth){
        if(node.left!=null)searchNode(node.left,depth+1);
        if(node.right!=null)searchNode(node.right,depth+1);
        if(node.left==null && node.right==null){
            if(depth>maxDepth){
                answer = 0;
                answer+=node.val;
                maxDepth = depth;
            }else if(depth==maxDepth){
                answer+=node.val;                
            }
            
        }
    }
}