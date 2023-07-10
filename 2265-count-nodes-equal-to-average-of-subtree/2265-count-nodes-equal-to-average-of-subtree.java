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
    public int averageOfSubtree(TreeNode root) {
        postOrder(root);
        return answer;
    }

    private int answer;

    Info postOrder(TreeNode node){
        int total = 1;
        int sum = node.val;
        Info leftInfo;
        Info rightInfo;
        if(node.left!=null){
            leftInfo = postOrder(node.left);
            total+= leftInfo.total;
            sum+= leftInfo.sum;
        }
        if(node.right!=null){
            rightInfo = postOrder(node.right);
            total+= rightInfo.total;
            sum+= rightInfo.sum;
        }
        int avg = sum/ total;
        if(avg==node.val) answer++;
        return new Info(total, sum);
    }

    class Info{
        int total;
        int sum;

        public Info(int total, int sum) {
            this.total = total;
            this.sum = sum;
        }
    }
}