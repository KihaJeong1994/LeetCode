class Solution {
    boolean[] visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        visited = new boolean[n];
        dfs(0,rooms);
        for(boolean b : visited){
            if(!b) return false;
        }
        return true;
    }

    private void dfs(int i,List<List<Integer>> rooms) {
        visited[i] = true;
        for(int room :rooms.get(i)){
            if(!visited[room]){
                dfs(room,rooms);
            }
        }
    }
}