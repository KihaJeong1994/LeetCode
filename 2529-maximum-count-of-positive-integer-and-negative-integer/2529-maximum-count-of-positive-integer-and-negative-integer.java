class Solution {
    public int maximumCount(int[] nums) {
        Integer lastMinusIdx = searchLastMinusIdx(nums);
        Integer firstPlusIdx = searchFirstPlusIdx(nums);
        int minusCnt = lastMinusIdx!=null ? lastMinusIdx+1 : 0;
        int plusCnt = firstPlusIdx!=null ? nums.length-firstPlusIdx : 0;
        return Math.max(minusCnt,plusCnt);
    }

    private Integer searchLastMinusIdx(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while (start<=end){
            int mid = (start+end)/2;
            if(isLastMinus(mid,nums)){
                return mid;
            } else if (isMinusAfter(mid,nums)) {
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return null;
    }

    private Integer searchFirstPlusIdx(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while (start<=end){
            int mid = (start+end)/2;
            if(isFirstPlus(mid,nums)){
                return mid;
            } else if (isPlusBefore(mid,nums)) {
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return null;
    }

    private boolean isPlusBefore(int mid, int[] nums) {
        if(mid==0){
            return false;
        }
        if(nums[mid-1]>0) return true;
        return false;
    }

    private boolean isFirstPlus(int mid, int[] nums) {
        if(mid==0){
            return nums[mid]>0;
        }
        if(nums[mid-1]*nums[mid]==0 && nums[mid-1]+nums[mid]>0) return true;
        if(nums[mid-1]*nums[mid]<0) return true;
        return false;
    }



    private boolean isMinusAfter(int mid, int[] nums) {
        if(mid==nums.length-1){
            return false;
        }
        if(nums[mid+1]<0) return true;
        return false;
    }

    private boolean isLastMinus(int mid, int[] nums) {
        if(mid==nums.length-1){
            return nums[mid]<0;
        }
        if(nums[mid]*nums[mid+1]==0 && nums[mid]+nums[mid+1]<0) return true;
        if(nums[mid]*nums[mid+1]<0) return true;
        return false;
    }
}