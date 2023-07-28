class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0; // the last index that should be changed
        int answer = 0;
        for(int j=0; j<nums.length; j++){
            if(nums[j]!=val){
                answer++;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
        }
        return answer;
    }
}