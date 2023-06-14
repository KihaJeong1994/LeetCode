class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int size = queries.length;
        int[] answer = new int[size];
        for(int[] point : points){
            for(int j=0; j<size;j++){
                int[] query = queries[j];
                if(distanceSquare(point[0],point[1],query[0],query[1])<=query[2]*query[2]){
                    answer[j]++;
                }
            }
        }
        return answer;
    }
    
    private int distanceSquare(int x1,int y1,int x2,int y2){
        return (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
    }
}