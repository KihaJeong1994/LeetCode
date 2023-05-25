class Solution {
    public int majorityElement(int[] nums) {
        int majorityCnt = 0;
        int majority = nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            Integer cnt = map.getOrDefault(n, 0);
            map.put(n, ++cnt);
            if(cnt>majorityCnt){
                majority = n;
                majorityCnt = cnt;
            }
        }
        return majority;
        
    }
}