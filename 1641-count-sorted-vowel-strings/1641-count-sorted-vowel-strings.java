class Solution {
    public int countVowelStrings(int n) {
        int[] dp = new int[6];
        int sum = 0;
        for(int i=1;i<=5;i++){
            dp[i] = 1;
        }
        for(int i=2; i<=n;i++){
            for(int j=1;j<=5;j++){
                dp[j] = dp[j-1] + dp[j];
            }
        }
        for(int i=1;i<=5;i++){
            sum+=dp[i];
        }
        return sum;
    }
}