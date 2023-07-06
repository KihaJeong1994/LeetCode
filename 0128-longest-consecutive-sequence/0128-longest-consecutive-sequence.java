class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n: nums){
            set.add(n);
        }
        List<Integer> firstNodes = new ArrayList<>();
        for(int n: set.stream().toList()){
            if(!set.contains(n-1)){
                firstNodes.add(n);
            }
        }
        int max = 0;
        for(int n : firstNodes){
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