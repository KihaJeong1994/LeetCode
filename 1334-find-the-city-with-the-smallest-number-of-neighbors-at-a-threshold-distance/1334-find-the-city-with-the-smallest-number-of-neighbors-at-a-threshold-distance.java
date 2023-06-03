class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distances = new int[n][n];
        for(int i=0; i<n ; i++){
            for(int j=0; j<n;j++){
                if(i==j){
                    distances[i][j] = 0;    
                }else{
                    distances[i][j] = 1000001;    
                }
                
            }
        }
        for(int[] edge : edges){
            distances[edge[0]][edge[1]] = edge[2];
            distances[edge[1]][edge[0]] = edge[2];
        }
        
        for(int k=0; k<n; k++){
            for(int i=0; i<n ; i++){
                for(int j=0; j<n;j++){
                    distances[i][j] = Math.min(distances[i][j], distances[i][k]+distances[k][j]);
                }
            }
        }
        int answer = 0;
        int smallestDistanceCnt = n+1;
        for(int i=0; i<n ; i++){
            int distanceCnt = 0;
            for(int j=0; j<n;j++){
                if(distances[i][j]<=distanceThreshold){
                    distanceCnt++;
                }
            }
            if(distanceCnt>0 && distanceCnt<=smallestDistanceCnt){
                smallestDistanceCnt = distanceCnt;
                answer = i;
            }
        }
        return answer;
    }
}