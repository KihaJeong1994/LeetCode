class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones){
            pq.offer(stone);
        }
        while(pq.size()>1){
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            if(stone1!=stone2){
                pq.offer(Math.abs(stone1-stone2));
            }
        }
        if(pq.size()==0) return 0;
        return pq.peek();
    }
}