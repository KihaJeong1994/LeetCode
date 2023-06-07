class Solution {
    public int maxCoins(int[] piles) {
        int answer =0;
        Arrays.sort(piles);
        int n = piles.length/3;
        for(int i=3*n-2 ; i>=n; i-=2){
            answer+=piles[i];
        }
        return answer;
    }
}