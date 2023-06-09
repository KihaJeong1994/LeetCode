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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(0,nums.length-1,nums);
    }
    
    public TreeNode helper(int start, int end,int[] nums){
        if(start>end){
            return null;
        }
        int maxNum = nums[start];
        int idx = start;
        for(int i=start;i<=end;i++){
            if(nums[i]>maxNum){
                maxNum = nums[i];
                idx = i;
            }
        }
        TreeNode node = new TreeNode(maxNum);
        node.left = helper(start,idx-1,nums);
        node.right = helper(idx+1,end,nums);
        return node;
    }
}