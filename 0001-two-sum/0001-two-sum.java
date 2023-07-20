class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int length = nums.length;
        for(int i=0; i<length; i++){
            int n = nums[i];
            map.put(n,i);
            if(map.containsKey(target-n) && i!=map.get(target-n)){
                return new int[]{i,map.get(target-n)};
            }
        }
        for(int i=0; i<length; i++){
            int n = nums[i];
            if(map.containsKey(target-n)&& i!=map.get(target-n)){
                return new int[]{i,map.get(target-n)};
            }
        }
        return null;
    }
}