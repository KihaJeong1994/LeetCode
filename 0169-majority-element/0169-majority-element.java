class Solution {
    public int majorityElement(int[] nums) {
        int majorEnoughCnt = nums.length/2;
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            Integer cnt = map.getOrDefault(n, 0);
            map.put(n, ++cnt);
            if(cnt > majorEnoughCnt) return n;
        }
        return nums[0];
    }
}