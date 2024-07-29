class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] answer = new int[cost.length];
        answer[0] = cost[0];
        answer[1] = cost[1];
        for(int i=2; i<cost.length; i++){
            answer[i] = Math.min(answer[i-2]+cost[i], answer[i-1]+cost[i]);
        }
        return Math.min(answer[answer.length-1], answer[answer.length-2]);
    }
}