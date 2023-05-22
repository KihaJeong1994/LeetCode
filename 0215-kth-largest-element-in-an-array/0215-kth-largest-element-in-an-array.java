class Solution {
    public int findKthLargest(int[] nums, int k) {
        TreeNode root = new TreeNode(nums[0]);
        for(int i=1;i<nums.length;i++){
            TreeNode node = root;
            TreeNode newNode = new TreeNode(nums[i]);
            while(node!=null){
                if(nums[i]<=node.val){
                    if(node.left!=null){
                      node = node.left;  
                    } else{
                     node.left = newNode; break;    
                    }
                    
                }else{
                    if(node.right!=null){
                      node = node.right;  
                    } else{
                     node.right = newNode; break;    
                    }
                    
                }
                
            }
        }
        
        Stack<TreeNode> stack = new Stack<>();
        while(true){
            while(root!=null){
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            if(--k==0) return root.val;
            root = root.left;
        }
        
        
    }
    
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
}