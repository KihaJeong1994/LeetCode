class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    boolean[] bools;
    public List<List<Integer>> subsets(int[] nums) {
        for(int i=0; i<=nums.length; i++){
            bools = new boolean[nums.length];
            recFunc(nums,0,0,i);
        }
        return answer;
    }

    void recFunc(int[] nums, int idx, int cnt, int n){
        if(cnt == n){
            List<Integer> l =new ArrayList<>();
            for(int i=0; i< nums.length; i++){
                if (bools[i]){
                    l.add(nums[i]);
                }
            }
            answer.add(l);
        }else{
            for(int i=idx; i< nums.length; i++){
                bools[i]= true;
                recFunc(nums, i+1, cnt+1, n);
                bools[i]= false;
            }
        }
    }

    
}