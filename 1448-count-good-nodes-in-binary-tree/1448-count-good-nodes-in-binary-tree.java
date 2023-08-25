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
        int answer = 0;
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(root, root.val));
        while (!queue.isEmpty()){
            Info info = queue.poll();
            TreeNode node = info.node;
            if(node.val>=info.maxVal) answer++;
            if(node.left!=null) queue.add(new Info(node.left, Math.max(info.maxVal, node.left.val)));
            if(node.right!=null) queue.add(new Info(node.right, Math.max(info.maxVal, node.right.val)));
        }
        return answer;
    }

    static class Info{
        TreeNode node;
        int maxVal;

        public Info(TreeNode node, int maxVal) {
            this.node = node;
            this.maxVal = maxVal;
        }
    }
}