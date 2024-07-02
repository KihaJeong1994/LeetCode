class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // 1<=k<=max(piles)
        // what I should check is sum of ceil(piles[i]/k) <=h
        // however, ceil(piles[i]/k) is not consistent, so I think I should try every k => O(k)
        // in this case, if k=x does not satisfy above condition, then we can get rid of 1~x-1 
        // so I can use binary search to find appropriate k => O(n log k)
        int l = 1;
        int r = 1;
        for(int pile : piles){
            r = Math.max(pile,r);
        }
        int answer = r;

        while(l<=r){
            int mid = (l+r)/2;
            long sumH = 0;
            for(int pile : piles){
                sumH += divideAndCeil(pile, mid);
            }
            // if it takes more hour, koko should eat faster
            if(sumH>h){
                l = mid+1;
            }else{
                answer = Math.min(answer,mid);
                r = mid-1;
            }
        }
        return answer;
        
    }

    private int divideAndCeil(int a, int b){
        return (a+b-1)/b;
    }
}