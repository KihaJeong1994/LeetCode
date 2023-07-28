class Solution {
    public int removeElement(int[] nums, int val) {
        for(int i=nums.length-1; i>0; i--){
            for(int j=0; j<i; j++){
                if(nums[j]==val){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
        int cnt = 0;
        for(int n: nums){
            if(n!=val){
                cnt++;
            }else {
                break;
            }
        }
        return cnt;
    }
}