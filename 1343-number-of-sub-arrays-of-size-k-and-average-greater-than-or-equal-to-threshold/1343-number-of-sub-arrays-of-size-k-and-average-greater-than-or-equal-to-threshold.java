class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int answer = 0;
        int len = arr.length;
        Integer slidingWindowSum = null;
        int thresholdMul = threshold*k;
        for(int i=0; i<len-k+1; i++){
            if(slidingWindowSum==null){
                slidingWindowSum = 0;
                for(int j=i; j<i+k; j++){
                    slidingWindowSum+=arr[j];
                }
            }else{
                slidingWindowSum = slidingWindowSum - arr[i-1] + arr[i+k-1];
            }
            if(slidingWindowSum>=thresholdMul){
                answer++;
            }
        }
        return answer;
    }
    
}