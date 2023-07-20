class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 2 7 11 15
        // 2
        // 7
        
        // 3 2 4
        // 3
        // 2 4
        int length = nums.length;
        for(int i=0; i<length-1; i++){
            for(int j=i+1; j<length; j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}