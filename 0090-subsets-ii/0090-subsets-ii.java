class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    Set<List<Integer>> answerSet = new HashSet<>();
    List<Integer> sample = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<=nums.length; i++){
            backTracking(0, nums, 0, i);
        }
        return answer;
    }

    private void backTracking(int currIdx, int[] nums, int cnt, int total){
        if(cnt==total){
            List<Integer> answerSample = new ArrayList<>();
            for(int i : sample){
                answerSample.add(i);
            }
            if(!answerSet.contains(answerSample)){
                answer.add(answerSample);
                answerSet.add(answerSample);
            }
            
        }else{
            for(int i=currIdx; i<nums.length; i++){
                sample.add(nums[i]);
                backTracking(i+1, nums, cnt+1, total);
                sample.remove(sample.size()-1);
            }
        }
    }
}