class Solution {
    public int search(int[] nums, int target) {
        // find minimum index num first
        int minIndex = findMinIndex(nums);

        // do binary search for 2 times
        int l1 = 0;
        int r1 = minIndex-1;
        int l2 = minIndex;
        int r2 = nums.length-1;
        
        if(minIndex!=0){
            int idx1 = findIndex(nums, l1, r1, target);
            if(idx1!=-1){
                return idx1;
            }
        }
        return findIndex(nums, l2, r2, target);

    }

    private int findIndex(int[] nums, int l, int r, int target){
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]<target){
                l = mid +1;
            }else if(nums[mid]>target){
                r = mid -1;
            }else{
                return mid;
            }
        }

        return -1;
    }

    private int findMinIndex(int[] nums){
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]<nums[l]){
                r = mid - 1;
            }else if (nums[mid]>nums[r]){
                l = mid + 1;
            }else{
                return l;
            }
            if(mid!=0 && nums[mid]<nums[mid-1]){
                return mid;
            }
        }
        
        return 0;
    }
}