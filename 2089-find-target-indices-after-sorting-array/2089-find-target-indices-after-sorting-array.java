class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> answerList = new ArrayList<>();
        Arrays.sort(nums);
        Integer targetIdx = binarySearch(nums,target);
        if(targetIdx==null){
            return answerList;
        }
        int minIdx = 0;
        int maxIdx = nums.length-1;
        for(int i=targetIdx+1; i<nums.length; i++){
            if(nums[i]>target){
                maxIdx = i-1;
                break;
            }
        }
        for(int i=targetIdx-1; i>=0; i--){
            if(nums[i]<target){
                minIdx = i+1;
                break;
            }
        }
        for(int i=minIdx;i<=maxIdx;i++){
            answerList.add(i);
        }
        return answerList;
        
    }
    
    private Integer binarySearch(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return null;
    }
    
}