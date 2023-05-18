class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int k = n%2 == 0 ? n/2 : (n-1)/2;
        int rowMax = k;
        int colMax = n%2 ==0? k : k+1;
        for(int i=0;i<rowMax;i++){
            for(int j=0;j<colMax;j++){
                int tmp = matrix[j][n-1-i];
                matrix[j][n-1-i] = matrix[i][j];
                int tmp2 = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = tmp;
                int tmp3 = matrix[n-1-j][i];
                matrix[n-1-j][i] = tmp2;
                matrix[i][j] = tmp3;
            }
        }
    }
}