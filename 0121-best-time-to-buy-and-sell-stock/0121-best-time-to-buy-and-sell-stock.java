class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 0;
        int answer = 0;
        while(r<prices.length){
            if(prices[l]>prices[r]){
                l = r;
                r = l;
            }else{
                answer = Math.max(answer, prices[r]-prices[l]);
                r++;
            }
        }
        return answer;
    }
}