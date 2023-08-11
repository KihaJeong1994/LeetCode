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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = helper(preorder,0,preorder.length-1);
        return root;
    }

    TreeNode helper(int[] preorder, int start, int end){
        TreeNode root = new TreeNode(preorder[start]);
        int firstLarger = fullSearch(preorder,start,end);
        if(start<preorder.length &&firstLarger>start+1 ) root.left = helper(preorder, start+1, firstLarger-1);
        if(end<preorder.length && firstLarger<=end) root.right = helper(preorder, firstLarger, end);
        return root;
    }

    int fullSearch(int[] preorder, int start, int end){
        for(int i = start+1; i<=end; i++){
            if(preorder[i]>preorder[start]) return i;
        }
        return end+1;
    }
}