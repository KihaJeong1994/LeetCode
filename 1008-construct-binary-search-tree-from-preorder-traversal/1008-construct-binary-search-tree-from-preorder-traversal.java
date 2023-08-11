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
        int firstLarger = binarySearch(preorder,start,end);
        if(start<preorder.length &&firstLarger>start+1) root.left = helper(preorder, start+1, firstLarger-1);
        if(end<preorder.length && firstLarger<=end) root.right = helper(preorder, firstLarger, end);
        return root;
    }

    int binarySearch(int[] preorder, int start, int end){
        int left = start;
        int right = end+1;
        int target = preorder[start]+1;
        while (left<right){
            int mid = (left+right)/2;
            if(preorder[mid]<target){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}