class Solution {
    private List<List<Integer>> answerList = new ArrayList<>();
    private int numsLength;
    private int[] globalNums , emptyArr;
    private boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        numsLength = nums.length;
        emptyArr = new int[numsLength];
        globalNums = nums;
        for(int i=0; i<numsLength; i++){
            used = new boolean[numsLength];
            recFunc(i,0);
        }
        return answerList;
    }
    
    public void recFunc(int i, int k){
        emptyArr[k] = globalNums[i];
        used[i] = true;
        if(numsLength == k+1){
            List<Integer> sample = new ArrayList<>();
            for(Integer x : emptyArr) sample.add(x);
            answerList.add(sample);
        }else{
            for(int j=0;j<numsLength;j++){
                if(!used[j]){
                  recFunc(j,k+1); 
                  used[j] = false;
                } 
            }
            
        }
    }
}