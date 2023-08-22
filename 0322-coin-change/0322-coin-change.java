class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int[] dp = new int[amount+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        for(int coin : coins){
            if(coin<=amount) dp[coin] = 1;
        }
        for(int i=1; i<=amount; i++){
            for(int coin : coins){
                if(i>coin && dp[i-coin]!=-1){
                    dp[i] = dp[i]!=-1 ? Math.min(dp[i-coin]+1, dp[i]) : dp[i-coin]+1;
                }
            }
        }
        return dp[amount];
    }
}