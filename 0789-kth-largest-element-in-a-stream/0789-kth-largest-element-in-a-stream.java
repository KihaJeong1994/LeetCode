class KthLargest {
    PriorityQueue<Integer> pq;
    int capacity;
    public KthLargest(int k, int[] nums) {
        capacity = k;
        pq = new PriorityQueue<>(k);
        for(int num : nums){
            if(pq.size()>=k){
                if( num > pq.peek()){
                    pq.poll();
                    pq.offer(num);
                }
            }else{
                pq.offer(num);
            }   
        }
    }
    
    public int add(int val) {
        if(pq.size()>=capacity){
            if( val > pq.peek()){
                pq.poll();
                pq.offer(val);
            }
        }else{
            pq.offer(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */