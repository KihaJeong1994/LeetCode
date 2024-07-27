class Solution {
    public int climbStairs(int n) {
        int[] answer = new int[n+1];
        answer[1] = 1;
        if(n>1) answer[2] = 2;
        for(int i=3; i<=n; i++){
            answer[i] = answer[i-1]+answer[i-2];
        }
        return answer[n];
    }
}