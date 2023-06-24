class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int low = 0;
        int high = nums.length-1;
        int[] answer = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(low>high) break;
            if(nums[i]<pivot){
                answer[low++] = nums[i];
            }
            if(nums[nums.length-1-i]>pivot){
                answer[high--] = nums[nums.length-1-i];
            }
        }
        
        while(low<=high){
            answer[low++] = pivot;
        }
        return answer;
        
    }
}