class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    Deque<Integer> stack = new ArrayDeque<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        recFunc(nums,0);
        return answer;
    }

    private void recFunc(int[] nums, int cnt){
        if(cnt==nums.length){
            List<Integer> l = new ArrayList<>();
            for(int n:stack){
                l.add(n);
            }
            answer.add(l);
        }else{
            for(int i=0; i<nums.length; i++){
                if(!used[i]){
                    used[i]= true;
                    stack.offer(nums[i]);
                    recFunc(nums, cnt+1);
                    stack.pollLast();
                    used[i]= false;
                }
            }

        }
    }




}