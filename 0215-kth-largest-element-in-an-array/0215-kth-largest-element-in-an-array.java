class Solution {
    public int findKthLargest(int[] nums, int k) {
        int index = nums.length-k;
        int pivotIndex = (nums.length/2);
        int left =0;
        int right = nums.length-1;
        while(true){
            if(left==right) return nums[left];
            pivotIndex = (left+right)/2;
            pivotIndex = partition(nums, left, right, pivotIndex);
            if(index==pivotIndex){
              return nums[index];  
            }else if(index<pivotIndex){
                right = pivotIndex-1;
            }else{
                left = pivotIndex+1;
            }
        }
    }
    
    
    private int partition(int[] nums, int left, int right, int pivotIndex){
        int pivotValue = nums[pivotIndex];
        swap(nums,pivotIndex,right);
        int storedIndex = left;
        for(int i=left; i<right;i++){
            if(nums[i]<=pivotValue){
                swap(nums,i,storedIndex);
                storedIndex++;
            }
        }
        swap(nums,right,storedIndex);
        return storedIndex;
    }
    
    
    private void swap(int[] nums, int left, int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
    
    
}