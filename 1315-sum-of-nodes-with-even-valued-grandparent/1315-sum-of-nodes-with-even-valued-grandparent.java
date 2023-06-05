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
    public int sumEvenGrandparent(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int answer = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left!=null){
                queue.add(node.left);
                if(node.val%2==0){
                    if(node.left.left!=null){
                        answer+=node.left.left.val;
                    }
                    if(node.left.right!=null){
                        answer+=node.left.right.val;
                    }
                }
                
            }
            if(node.right!=null){
                queue.add(node.right);
                if(node.val%2==0){
                    if(node.right.left!=null){
                        answer+=node.right.left.val;
                    }
                    if(node.right.right!=null){
                        answer+=node.right.right.val;
                    }
                }
                
            }
        }
        return answer;
    }
    

}