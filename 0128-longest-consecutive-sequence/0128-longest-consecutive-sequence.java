class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n: nums){
            set.add(n);
        }
        List<Integer> firstNums = new ArrayList<>();
        for(int n: nums){
            if(!set.contains(n-1)){
                firstNums.add(n);
            }
        }
        int max = 0;
        for(int n : firstNums){
            int len = 0;
            while (set.contains(n)){
                len++;
                n++;
            }
            max = Math.max(max,len);
        }
        return max;
    }

}