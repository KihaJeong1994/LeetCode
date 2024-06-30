class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // car fleet : car alone or the cars that reach the target together
        // calculate the distance left to reach the target
        int answer = 1;
        DistanceAndSpeed[] arr = new DistanceAndSpeed[position.length];
        for(int i=0; i< position.length; i++){
            arr[i] = new DistanceAndSpeed(target - position[i],speed[i]) ;
        }
        Arrays.sort(arr, (a,b)->a.distance-b.distance);
        
        double maxTta = arr[0].tta;
        for(int i=0; i<arr.length-1; i++){
            if(maxTta < arr[i+1].tta){
                maxTta = arr[i+1].tta;
                answer++;
            }
        }
        
        return answer;
    }
    
    private static class DistanceAndSpeed{
        int distance;
        int speed;
        double tta;
        DistanceAndSpeed(int distance, int speed){
            this.distance=distance;
            this.speed=speed;
            this.tta = (double)distance/(double)speed;
        }
    }
}