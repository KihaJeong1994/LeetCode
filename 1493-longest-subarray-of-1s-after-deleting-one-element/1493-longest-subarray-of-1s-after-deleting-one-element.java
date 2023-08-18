class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        int start = 0, end=0, zeroCnt = 0;
        while (end<nums.length){
            if(nums[end]==0){
                zeroCnt++;
            }
            while (zeroCnt>1){
                if(nums[start]==0){
                    zeroCnt--;
                }
                start++;
            }
            max = Math.max(max, end-start);
            end++;
        }
        return max;
    }
}