class Solution {
    private int[] rowMaxs, colMaxs;
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int answer = 0;
        int n = grid.length;
        rowMaxs = new int[n];
        colMaxs = new int[n];
        for(int i=0;i<n;i++){
            int rowMax =0;
            int colMax =0;
            for(int j=0;j<n;j++){
                if(rowMax < grid[i][j]) rowMax = grid[i][j];
                if(colMax < grid[j][i]) colMax = grid[j][i];
            }
            rowMaxs[i] = rowMax;
            colMaxs[i] = colMax;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                answer += Math.min(rowMaxs[i],colMaxs[j]) - grid[i][j];
                grid[i][j] = Math.min(rowMaxs[i],colMaxs[j]);
            }
        }
        return answer;
    }
}