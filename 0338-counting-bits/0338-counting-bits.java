class Solution {
    public int[] countBits(int n) {
        int[] answer = new int[n+1];
        answer[0] = 0;
        if(n==0) return answer;
        answer[1] = 1;
        for(int i=2;i<n+1;i++){
            answer[i] = answer[i-(int)Math.pow(2,(int)(Math.log(i)/Math.log(2)))]+1;
        }
        return answer;
    }
}