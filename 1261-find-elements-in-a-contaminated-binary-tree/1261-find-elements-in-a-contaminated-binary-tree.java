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
class FindElements {
    private TreeNode root;
    private Set<Integer> elements;

    public FindElements(TreeNode root) {
        this.root = root;
        elements = new HashSet<>();
        recover(root);
    }
    
    public boolean find(int target) {
        return elements.contains(target);
    }
    
    private void recover(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        root.val = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            elements.add(node.val);
            if(node.left!=null){
                node.left.val = node.val*2+1;
                queue.add(node.left);
            }
            if(node.right!=null){
                node.right.val = node.val*2+2;
                queue.add(node.right);
            }
        }
        
    }
    
    
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */