class Solution {
    public int findCenter(int[][] edges) {
        for(int n : edges[0]){
            if(n==edges[1][0]||n==edges[1][1]){
                return n;
            }
        }
        return 1;
    }
}