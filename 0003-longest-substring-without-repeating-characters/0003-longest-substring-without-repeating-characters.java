class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int r=0;
        int answer = 0;
        char[] sCharArray = s.toCharArray();
        Set<Character> set = new HashSet<>();
        while(r<sCharArray.length){
            if(!set.contains(sCharArray[r])){
                set.add(sCharArray[r]);
                r++;
            }else{
                answer = Math.max(r-l,answer);
                set.remove(sCharArray[l]);
                l = l+1;
            }
        }
        answer = Math.max(set.size(),answer);
        return answer;

    }
}