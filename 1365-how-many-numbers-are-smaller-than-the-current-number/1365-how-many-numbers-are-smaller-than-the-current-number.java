class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] answer = new int[nums.length];
        int[] copy = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            copy[i] = nums[i];
        }
        Map<Integer,Integer> numLessCnt = new HashMap<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            int start = 0;
            int end = nums.length;
            while(start<end){
                int mid = (start+end)/2;
                if(nums[mid]>=num){
                    end = mid;
                }else{
                    start = mid+1;
                }
            }
            numLessCnt.put(nums[i],start);
        }
        for(int i=0; i<nums.length; i++){
            answer[i] = numLessCnt.get(copy[i]);
        }
        return answer;
    }
}