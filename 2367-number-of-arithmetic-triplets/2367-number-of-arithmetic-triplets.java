class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        for (int i=0; i<nums.length;i++){
            recFunc(nums, diff, i, 0);
        }
        return answer;
    }
    int answer;
    void recFunc(int[] nums,int diff, int i, int k){
        if(k==2){
            answer++;
        }else{
            for(int j=i+1; j<nums.length;j++){
                if(nums[j]==nums[i]+diff) recFunc(nums, diff, j, k+1);
            }
        }

    }
}