class Solution {
    public int countSquares(int[][] matrix) {
        int answer = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int min = Math.min(m, n);
        boolean[][] dp = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] ==1){
                    dp[i][j] = true;
                    answer++;
                }
            }
        }
        for(int len=2; len<=min; len++){
            boolean[][] newDp = new boolean[m][n];
            for(int i=0; i<m-len+1; i++){
                for(int j=0; j<n-len+1; j++){
                    if(dp[i][j]&&dp[i+1][j]&&dp[i][j+1]&&dp[i+1][j+1]){
                        newDp[i][j] = true;
                        answer++;
                    }
                }
            }
            dp = newDp;
        }
        return answer;
    }
}