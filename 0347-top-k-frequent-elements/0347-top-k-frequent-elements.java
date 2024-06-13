class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // must be less than O(n log n)
        // 1. count every num -> O(n)
        Map<Integer, NumCnt> map = new HashMap<>();
        for(int num : nums){
            NumCnt numCnt = map.getOrDefault(num, new NumCnt(num));
            numCnt.add();
            map.put(num, numCnt);
        }
        // 2. Create array of class with num and cnt O(n)
        // 3. sort array by cnt O(n log n)
        List<Integer> sortedNums = map.values().stream().sorted((a, b) -> b.cnt - a.cnt).map(numCnt -> numCnt.num).toList();
        
        // 4. return first kth classes
        int[] answer = new int[k];
        for(int i=0; i<k; i++){
            answer[i] = sortedNums.get(i);
        }
        return answer;
    }
    
    static class NumCnt{
        int num;
        int cnt;
        NumCnt(int num){
            this.num = num;
            this.cnt = 0;
        }
        void add(){
            this.cnt++;
        }
    }
}