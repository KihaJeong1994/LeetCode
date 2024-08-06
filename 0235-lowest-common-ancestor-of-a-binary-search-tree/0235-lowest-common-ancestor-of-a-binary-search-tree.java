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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        int pdiff = node.val-p.val;
        int qdiff = node.val-q.val;
        while((pdiff>0 && qdiff>0) || (pdiff<0 && qdiff<0)){
            if(pdiff>0){
                node = node.left;
            }else{
                node = node.right;
            }
            pdiff = node.val-p.val;
            qdiff = node.val-q.val;
        }
        return node;
    }
}