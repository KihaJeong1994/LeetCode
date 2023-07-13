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
    public TreeNode reverseOddLevels(TreeNode root) {
        // bfs with holding level
        Queue<Info> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.add(new Info(root,0));
        int idx = 0;
        int level = 0;
        while(!queue.isEmpty()){
            Info info = queue.poll();
            if(level!=info.level){
                idx = 0;
                level = info.level;
            }
            double levelLength = Math.pow(2, info.level+1);
            TreeNode node = info.node;
            TreeNode leftNode = node.left;
            if(leftNode !=null){
                if(info.level%2==0){
                    if(idx>=levelLength/2){
                        TreeNode reverseNode = stack.pop();
                        int tmp = reverseNode.val;
                        reverseNode.val = leftNode.val;
                        leftNode.val = tmp;
                    }else {
                        stack.push(leftNode);
                    }
                }
                queue.add(new Info(leftNode,info.level+1));
                idx++;
            }
            TreeNode rightNode = node.right;
            if(rightNode !=null){
                if(info.level%2==0){
                    if(idx>=levelLength/2){
                        TreeNode reverseNode = stack.pop();
                        int tmp = reverseNode.val;
                        reverseNode.val = rightNode.val;
                        rightNode.val = tmp;
                    }else {
                        stack.push(rightNode);
                    }
                }
                queue.add(new Info(rightNode,info.level+1));
                idx++;
            }
        }
        return root;

    }

    class Info{
        TreeNode node;
        int level;
        Info(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
    
    
}