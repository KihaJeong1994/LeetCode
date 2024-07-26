class LRUCache {
    private Deque<Integer> queue;
    private Map<Integer, Integer> keyValueMap;
    private Map<Integer, Integer> keyCntMap;
    private int capacity;

    public LRUCache(int capacity) {
        keyValueMap = new HashMap<>();
        keyCntMap = new HashMap<>();
        queue = new ArrayDeque<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!keyValueMap.containsKey(key)){
            return -1;
        }else{
            keyCntMap.put(key,keyCntMap.get(key)+1);
            queue.offer(key);
            return keyValueMap.get(key);
        }
    }
    
    public void put(int key, int value) {
        if(keyValueMap.containsKey(key)){
            keyValueMap.put(key, value);
            keyCntMap.put(key,keyCntMap.get(key)+1);
            queue.offer(key);
        }else{
            while(capacity==0){
                int num = queue.pollFirst();
                if(keyCntMap.get(num)>1){
                    keyCntMap.put(num,keyCntMap.get(num)-1);
                }else{
                    keyCntMap.remove(num);
                    keyValueMap.remove(num);
                    capacity++;
                }
            }
            keyValueMap.put(key, value);
            keyCntMap.put(key,1);
            queue.offer(key);
            capacity--;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */