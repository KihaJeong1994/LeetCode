class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int answer = 0;
        int len = arr.length;
        int slidingWindowSum = 0;
        int thresholdMul = threshold*k;
        for(int j=0; j<k; j++){
            slidingWindowSum+=arr[j];
        }
        if(slidingWindowSum>=thresholdMul){
            answer++;
        }
        for(int i=1; i<len-k+1; i++){
            slidingWindowSum = slidingWindowSum - arr[i-1] + arr[i+k-1];
            if(slidingWindowSum>=thresholdMul){
                answer++;
            }
        }
        return answer;
    }
    
}