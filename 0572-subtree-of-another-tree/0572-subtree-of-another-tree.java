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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root != null){
            return isSameTree(root, subRoot)||isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }else{
            return isSameTree(root, subRoot);
        }
        
    }

    private boolean isSameTree(TreeNode node1, TreeNode node2){
        if(node1!=null && node2!=null){
            return node1.val==node2.val && isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
        }else if(node1==null && node2==null){
            return true;
        }else{
            return false;
        }
    }
}