class Solution {
    public int countSquares(int[][] matrix) {
        int answer = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] ==1 && i>=1 && j>=1){
                    matrix[i][j] = Math.min(Math.min(matrix[i-1][j-1], matrix[i-1][j]), matrix[i][j-1])+1;
                }
                answer += matrix[i][j];
            }
        }
        return answer;
    }
}