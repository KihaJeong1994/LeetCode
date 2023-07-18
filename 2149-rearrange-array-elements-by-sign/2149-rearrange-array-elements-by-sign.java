class Solution {
    public int[] rearrangeArray(int[] nums) {
        // 3,1,-2,-5,2,-4
        // 3 -2 1 -5 2 -4
        
        int[] answer = new int[nums.length];
        int positiveIdx = 0;
        int negativeIdx = 1;
        for(int n : nums){
            if(n>0){
                answer[positiveIdx] = n;
                positiveIdx+=2;
            }else{
                answer[negativeIdx] = n;
                negativeIdx+=2;
            }
        }
        return answer;
    }
}