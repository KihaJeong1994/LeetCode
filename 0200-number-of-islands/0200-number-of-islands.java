class Solution {
    boolean[][] visited;
    int answer=0;
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    bfs(grid, i, j,m,n);
                }
            }
        }
        return answer;
    }
    private void bfs(char[][] grid, int i, int j, int m, int n){
        Deque<Coordinate> queue = new ArrayDeque<>();
        queue.offer(new Coordinate(i,j));
        visited[i][j] = true;
        while(!queue.isEmpty()){
            Coordinate c = queue.pollFirst();
            int x = c.x;
            int y = c.y;
            if(x+1<m && !visited[x+1][y] && grid[x+1][y]=='1'){
                queue.offer(new Coordinate(x+1,y));
                visited[x+1][y] = true;
            }
            if(x-1>=0 && !visited[x-1][y] && grid[x-1][y]=='1'){
                queue.offer(new Coordinate(x-1,y));
                visited[x-1][y] = true;
            }
            if(y+1<n && !visited[x][y+1] && grid[x][y+1]=='1'){
                queue.offer(new Coordinate(x,y+1));
                visited[x][y+1] = true;
            }
            if(y-1>=0 && !visited[x][y-1] && grid[x][y-1]=='1'){
                queue.offer(new Coordinate(x,y-1));
                visited[x][y-1] = true;
            }
        }
        answer++;
    }

    private static class Coordinate{
        int x;
        int y;
        Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}