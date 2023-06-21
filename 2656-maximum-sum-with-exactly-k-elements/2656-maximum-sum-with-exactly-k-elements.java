class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max = 0;
        for(int num:nums){
            max = Math.max(num,max);
        }
        return max*k + (k*(k-1))/2;
    }
}