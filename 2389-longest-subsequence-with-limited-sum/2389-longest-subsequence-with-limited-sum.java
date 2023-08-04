class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++){
            nums[i] = nums[i-1]+nums[i];
        }
        int[] answer = new int[queries.length];
        for(int i=0; i<answer.length; i++){
            int start = 0;
            int end = nums.length;
            while(start<end){
                int mid = (start+end)/2;
                if(nums[mid]<queries[i]){
                    start = mid+1;
                }else if(nums[mid]>queries[i]){
                    end = mid;
                }else{
                    start = mid+1;       
                    break;
                }
            }
            answer[i] = start;
        }
        return answer;
    }
}