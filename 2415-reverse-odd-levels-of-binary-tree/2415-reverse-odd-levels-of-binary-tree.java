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
        Map<Integer,TreeNode> map = new HashMap<>();
        queue.add(new Info(root,0,0));
        int idx = 0;
        int level = 0;
        while(!queue.isEmpty()){
            Info info = queue.poll();
            if(info.level%2==1){
                double levelLength = Math.pow(2, info.level);
                if(info.idx>=levelLength/2){
                    TreeNode treeNode1 = map.get(info.idx);
                    TreeNode treeNode2 = map.get((int)levelLength-1-info.idx);
                    int tmp = treeNode1.val;
                    treeNode1.val = treeNode2.val;
                    treeNode2.val = tmp;
                }
            }
            if(level!=info.level){
                idx = 0;
                level = info.level;
            }
            if(info.node.left!=null){
                if(info.level%2==0){
                    map.put(idx,info.node.left);
                }
                queue.add(new Info(info.node.left,idx++,info.level+1));
            }
            if(info.node.right!=null){
                if(info.level%2==0){
                    map.put(idx,info.node.right);
                }
                queue.add(new Info(info.node.right,idx++,info.level+1));
            }
        }
        return root;

    }

    class Info{
        TreeNode node;
        int idx;
        int level;
        Info(TreeNode node, int idx, int level){
            this.node = node;
            this.idx = idx;
            this.level = level;
        }

    }
    
    
}