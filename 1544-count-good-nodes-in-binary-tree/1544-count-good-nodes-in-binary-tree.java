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
    public int goodNodes(TreeNode root) {
        int answer = 1;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.pollFirst();
            if(node.left!=null){
                if(node.left.val>=node.val){
                    answer++;
                }else{
                    node.left.val = node.val;
                }
                queue.offer(node.left);
            }
            if(node.right!=null){
                if(node.right.val>=node.val){
                    answer++;
                }else{
                    node.right.val = node.val;
                }
                queue.offer(node.right);
            }
        }
        return answer;
    }


}