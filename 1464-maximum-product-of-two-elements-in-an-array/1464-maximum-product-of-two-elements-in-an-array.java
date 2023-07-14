class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = 0;
        int second = 0;
        for(int i=0; i<n; i++){
            if(nums[i]>max){
                second = max;
                max = nums[i];
            }else if(nums[i]>second){
                second = nums[i];
            }
        }
        return (max-1)*(second-1);
    }
}