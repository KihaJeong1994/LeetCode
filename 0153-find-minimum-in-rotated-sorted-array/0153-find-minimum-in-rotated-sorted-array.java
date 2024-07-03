class Solution {
    public int findMin(int[] nums) {
        // I don't know the time nums has been rotated
        // But, I know that since the original array was sorted, I need to find the point that num decrease
        // if nums[l] > nums[mid]  => decrease point is at left
        // if nums[mid] > nums[r] => decrease point is at right
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[l] > nums[mid]){
                r = mid-1;
            }else if(nums[mid] > nums[r]){
                l = mid +1;
            }else{
                return nums[l];
            }
            if(mid!=0 && nums[mid]<nums[mid-1]){
                return nums[mid];
            }
        }
        return 0;
    }
}