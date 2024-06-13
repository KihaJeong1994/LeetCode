class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. count all nums -> create map with num:cnt
        Map<Integer, Integer> numCntMap = new HashMap<>();
        for(int num : nums){
            Integer cnt = numCntMap.getOrDefault(num, 0);
            cnt++;
            numCntMap.put(num, cnt);
        }
        
        // 2. maximum num of cnt = nums.length
        // make array with length k and put num in kth element
        List<Integer>[] cntNumsList = new List[nums.length+1];
        for(int i=0; i< nums.length+1; i++){
            cntNumsList[i] = new ArrayList<>();
        }
        numCntMap.entrySet().forEach((e)->{
            cntNumsList[e.getValue()].add(e.getKey());
        });
        
        // 3. in reverse order, count k and fill in answer
        
        int[] answer = new int[k];
        int end = 0;
        for(int i = nums.length; i>=0; i--){
            List<Integer> integers = cntNumsList[i];
            for(int j=0; j<integers.size(); j++){
                if(k>0){
                    answer[end] = integers.get(j);
                    end++;
                    k--;
                }else{
                    break;
                }
            }
            if(k==0) break;
        }
        return answer;
    }
    

}