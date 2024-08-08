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
    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();
        if(root == null) return answer;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean started = false;
            for(int i=0; i<size; i++){
                TreeNode node = queue.pollFirst();
                if(!started){
                    started = true;
                    answer.add(node.val);
                }
                if(node.right!=null) queue.offer(node.right);
                if(node.left!=null) queue.offer(node.left);
            }
        }
        return answer;
    }
}