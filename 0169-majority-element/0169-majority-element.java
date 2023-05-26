class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int majorityCnt = 1;
        int n = nums.length;
        for(int i=1 ; i<n ; i++){
            if(majorityCnt==0){
                candidate = nums[i];
                majorityCnt++;
                continue;
            }
            if(nums[i]==candidate){
                majorityCnt++;
            }else {
                majorityCnt--;
            }

        }
        return candidate;
    }
}