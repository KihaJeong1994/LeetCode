class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] multiplyForward = new int[nums.length];
        int[] multiplyBackward = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0){
                multiplyForward[i] = nums[i];
                multiplyBackward[nums.length-1-i] = nums[nums.length-1-i];
            }else{
                multiplyForward[i] = multiplyForward[i-1] * nums[i];
                multiplyBackward[nums.length-1-i] = multiplyBackward[nums.length-1-i+1] * nums[nums.length-1-i];
            }
        }
        // int[] answer = new int[nums.length];
        for(int i=0; i< nums.length; i++){
            int forward = i!=0 ? multiplyForward[i-1] : 1;
            int backward = i!=nums.length-1 ? multiplyBackward[i+1] : 1;
            nums[i] = forward * backward;
        }
        return nums;
    }
}