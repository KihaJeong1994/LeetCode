class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] dp = new int[n];
        int tmp0 = nums[0];
        nums[0] = 0;
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<n; i++){
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        int tmpDp = Math.max(dp[n-2], dp[n-1]);
        dp = new int[n];
        nums[0] = tmp0;
        nums[n-1] = 0;
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<n; i++){
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return Math.max(dp[n-1],tmpDp);
        
    }
}