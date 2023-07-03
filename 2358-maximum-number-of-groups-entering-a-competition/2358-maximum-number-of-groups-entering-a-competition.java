class Solution {
    public int maximumGroups(int[] grades) {
        int n = grades.length;
        int start = 1;
        int end = n;
        long k = 1;
        boolean endOver = true;
        while(start<=end){
            k = (start+end)/2;
            long sum = k*(k+1)/2;
            if(sum==n){
                return (int)k;
            }else if(sum<n){
                start = (int)k+1;
                endOver = false;
            }else{
                end = (int)k-1;
                endOver = true;
            }
        }
        return !endOver?(int)k:(int)k-1;
    }
}