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
    Map<TreeNode, TreeNode> nodeParentNode = new HashMap<>();
    Map<TreeNode, Integer> nodeMaxVal = new HashMap<>();
    public int goodNodes(TreeNode root) {
        int answer = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.pollFirst();
            if(!nodeParentNode.containsKey(node)){
                answer++;
                nodeMaxVal.put(node, node.val);
            }else{
                TreeNode parentNode = nodeParentNode.get(node);
                int maxVal = nodeMaxVal.get(parentNode);
                if(node.val>=maxVal){
                    maxVal = node.val;
                    answer++;
                }
                nodeMaxVal.put(node, maxVal);
            }
            if(node.left!=null){
                queue.offer(node.left);
                nodeParentNode.put(node.left, node);
            }
            if(node.right!=null){
                queue.offer(node.right);
                nodeParentNode.put(node.right, node);
            }
        }
        return answer;
    }


}