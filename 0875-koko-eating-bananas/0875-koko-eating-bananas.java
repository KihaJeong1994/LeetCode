class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = max(piles);
        int answer = r;
        while (l<=r){
            int m = (l+r)/2;
            if(satisfying(piles,h,m)){
                answer = m;
                r = m-1;
            }else {
                l = m+1;
            }
        }
        return answer;
    }

    private boolean satisfying(int[] piles, int h, int m) {
        int hoursNeeded = 0;
        for(int pile : piles){
            hoursNeeded += (Math.ceil((double) pile/(double) m));
        }
        return hoursNeeded<=h;
    }

    int max(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            if(num>max) max = num;
        }
        return max;
    }
}