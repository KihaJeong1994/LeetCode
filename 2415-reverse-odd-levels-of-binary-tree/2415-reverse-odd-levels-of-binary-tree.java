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
            if(info.node.left!=null){
                if(info.level%2==0){
                    double levelLength = Math.pow(2, info.level+1);
                    if(idx>=levelLength/2){
                        TreeNode reverseNode = stack.pop();
                        int tmp = reverseNode.val;
                        reverseNode.val = info.node.left.val;
                        info.node.left.val = tmp;
                    }else {
                        stack.push(info.node.left);
                    }
                }
                queue.add(new Info(info.node.left,info.level+1));
                idx++;
            }
            if(info.node.right!=null){
                if(info.level%2==0){
                    double levelLength = Math.pow(2, info.level+1);
                    if(idx>=levelLength/2){
                        TreeNode reverseNode = stack.pop();
                        int tmp = reverseNode.val;
                        reverseNode.val = info.node.right.val;
                        info.node.right.val = tmp;
                    }else {
                        stack.push(info.node.right);
                    }
                }
                queue.add(new Info(info.node.right,info.level+1));
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

        @Override
        public String toString() {
            return "Info{" +
                    "node=" + node +
                    ", level=" + level +
                    '}';
        }
    }
    
    
}