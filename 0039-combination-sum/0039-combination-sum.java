class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> sample = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        // 1. sort candidates
        Arrays.sort(candidates);

        // 2. backtracking
        recFunc(0, candidates, 0, target);
        return answer;
    }

    private void recFunc(int currIdx, int[] candidates, int sum, int target){
        if(sum == target){
            List<Integer> answerSample = new ArrayList<>();
            for(int candidate: sample){
                answerSample.add(candidate);
            }
            answer.add(answerSample);
        }else{
            for(int i=currIdx; i<candidates.length; i++){
                if(sum+candidates[i]<=target){
                    sample.add(candidates[i]);
                    recFunc(i, candidates, sum+candidates[i], target);
                    sample.remove(sample.size()-1);
                }
            }
        }
        
    }
}