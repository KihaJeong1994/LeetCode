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
    List<String> path = new ArrayList<>();
    List<String> answerList = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        inorder(root);
        return answerList;
    }

    void inorder(TreeNode node){
        path.add(Integer.toString(node.val));
        if(node.left!=null) inorder(node.left);
        if(node.right!=null) inorder(node.right);
        if(node.left==null && node.right==null){
            answerList.add(String.join("->",path));
        }
        path.remove(path.size()-1);
    }
}