class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length/2;i++){
            int tmp = nums[nums.length-1-i];
            nums[nums.length-1-i] = nums[i];
            nums[i] = tmp;
        }
        return nums[k-1];
        
    }
    
    
}