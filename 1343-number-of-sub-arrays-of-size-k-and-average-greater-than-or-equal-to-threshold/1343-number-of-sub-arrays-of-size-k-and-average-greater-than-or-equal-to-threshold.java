class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int answer = 0;
        int len = arr.length;
        for(int i=0; i<len-k+1; i++){
            if(getAvg(arr,i,i+k-1)>=threshold){
                answer++;
            }
        }
        return answer;
    }
    
    private int getAvg(int[] arr, int start, int end){
        int sum = 0;
        for(int i=start; i<=end; i++){
            sum += arr[i];
        }
        return sum/(end-start+1);
    }
}