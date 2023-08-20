class Solution {
    public int numIdenticalPairs(int[] nums) {
        int answer = 0;
        int[] cnts = new int[101];
        for(int num : nums){
            cnts[num]++;
        }
        for(int cnt : cnts){
            answer += (cnt*(cnt-1))/2;
        }
        return answer;
        
    }
}