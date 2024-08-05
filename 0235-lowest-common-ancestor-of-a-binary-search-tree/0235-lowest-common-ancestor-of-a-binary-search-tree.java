/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    Deque<TreeNode> pAncestorStack = new ArrayDeque<>();
    boolean foundP = false;
    boolean foundQ = false;
    Set<TreeNode> qAncestorSet = new HashSet<>();
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfsP(root, p);
        dfsQ(root, q);
        TreeNode answer = null;
        while(!pAncestorStack.isEmpty()){
            TreeNode ancestor = pAncestorStack.pollFirst();
            if(qAncestorSet.contains(ancestor)){
                return ancestor;
            }
        }
        return answer;
    }

    void dfsP(TreeNode root, TreeNode p){
        if(root==null) return;
        if(root==p){
            pAncestorStack.offer(root);
            foundP = true;
            return;
        }
        if(!foundP){
            dfsP(root.left, p);
        }
        if(!foundP){
            dfsP(root.right, p);
        }
        if(foundP){
            pAncestorStack.offer(root);
        }
    }

    void dfsQ(TreeNode root, TreeNode p){
        if(root==null) return;
        if(root==p){
            qAncestorSet.add(root);
            foundQ = true;
            return;
        }
        if(!foundQ){
            dfsQ(root.left, p);
        }
        if(!foundQ){
            dfsQ(root.right, p);
        }
        if(foundQ){
            qAncestorSet.add(root);
        }
    }
}