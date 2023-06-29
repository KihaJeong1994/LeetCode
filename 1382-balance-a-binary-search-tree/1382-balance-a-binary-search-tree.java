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
    List<Integer> nums;

    public TreeNode balanceBST(TreeNode root) {
        nums = new ArrayList<>();
        // inorder traverse node -> nums will be automatically sorted
        traverse(root);

        // sorted array to Balanced BST
        int start = 0;
        int end = nums.size()-1;
        TreeNode result = sortedArrayToBalanceBST(start,end);
        return result;
    }

    private TreeNode sortedArrayToBalanceBST(int start, int end) {
        if(start>end) return  null;
        int mid = (start+end)/2;
        TreeNode head = new TreeNode(nums.get(mid));
        head.left = sortedArrayToBalanceBST(start,mid-1);
        head.right = sortedArrayToBalanceBST(mid+1,end);
        return head;
    }

    void traverse(TreeNode node){
        if(node.left!=null) traverse(node.left);
        visit(node); // inorder
        if(node.right!=null) traverse(node.right);
    }

    void visit(TreeNode node){
        nums.add(node.val);
    }
}