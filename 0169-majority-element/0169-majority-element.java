class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int majorEnoughCnt = nums.length/2;
        int cnt = 1;
        for(int i=1; i<n; i++){
            if(nums[i]==nums[i-1]){
                cnt++;
            }else{
                if(cnt>majorEnoughCnt){
                    return nums[i-1];
                }
                cnt = 1;
            }
            
        }
        return nums[n-1];
    }
}