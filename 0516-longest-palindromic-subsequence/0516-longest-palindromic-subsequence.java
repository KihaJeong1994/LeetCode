class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int ls=1; ls<=n; ls++){
            for(int i=0; i<=n-ls;i++){
                int j = i+ls-1;
                if(ls==1){
                    dp[i][j] = 1;
                    continue;
                }
                if(s.charAt(i)==s.charAt(j)){
                    if(ls==2){
                        dp[i][j] = 2;
                    }else{
                        dp[i][j] = dp[i+1][j-1]+2;
                    }
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        return dp[0][n-1];
    }
}