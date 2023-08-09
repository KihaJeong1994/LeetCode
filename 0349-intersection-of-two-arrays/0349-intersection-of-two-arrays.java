class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> answerSet = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        for(int n : nums1){
            set1.add(n);
        }
        for(int n: nums2){
            if(set1.contains(n)){
                answerSet.add(n);
            }
        }
        int[] answer = new int[answerSet.size()];
        int i=0;
        for (int num : answerSet) {
            answer[i] = num;
            i++;
        }
        return answer;
    }
}