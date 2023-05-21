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
    public TreeNode sortedArrayToBST(int[] nums) {
        return getTreeNodeFromTo(0,nums.length-1,nums);
    }
    
    private TreeNode getTreeNodeFromTo(int from, int to, int[] nums){
        if(to-from<0) return null;
        if(to-from==0) return new TreeNode(nums[to]);
        int mid = (from+to)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = getTreeNodeFromTo(from,mid-1, nums);
        root.right = getTreeNodeFromTo(mid+1, to, nums);
        return root;
    }
}