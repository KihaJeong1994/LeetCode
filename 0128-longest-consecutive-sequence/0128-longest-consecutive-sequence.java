class Solution {
    public int longestConsecutive(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int n : nums){
            pq.add(n);
        }

        Integer prev = null;
        int max = 0;
        int len = 0;
        while (!pq.isEmpty()){
            int n = pq.poll();
            if(prev!=null){
                if(prev == n-1){
                    len++;
                }else if(prev==n){
                    continue;
                }
                else{
                    len = 1;
                }
                prev = n;

            }else{
                prev = n;
                len = 1;
            }
            max = Math.max(len,max);
        }
        return max;
    }

}