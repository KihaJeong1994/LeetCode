class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] isAlive = new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0; j<n; j++){
                int neighbors = neighborCnt(i,j,board);
                boolean live = board[i][j] == 1;
                if(neighbors < 2 && live) isAlive[i][j] = false;
                else if (neighbors>=2 && neighbors<=3 && live) isAlive[i][j] = true;
                else if (neighbors>3 && live) isAlive[i][j] = false;
                else if (neighbors==3 && !live) isAlive[i][j] = true;
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0; j<n; j++){
                if(isAlive[i][j]) board[i][j] = 1;
                else board[i][j] = 0;
            }
        }
    }
    
    private int neighborCnt(int row, int col, int[][] board){
        int[] dx = {-1,0,1};
        int[] dy = {-1,0,1};
        int n = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i==1 && j==1) continue;
                if(row+dx[i]>=0 && row+dx[i]<board.length && col+dy[j]>=0 && col+dy[j]<board[0].length){
                    if(board[row+dx[i]][col+dy[j]]==1) n++;
                }
            }
        }
        return n;
    }
}