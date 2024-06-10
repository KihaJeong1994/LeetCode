class Solution {
    public boolean isAnagram(String s, String t) {
        // 1. declare array that record the diff between cnt of char in s and t
        int[] charDiffCnt = new int[26];
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        for(char c : sCharArray){
            charDiffCnt[c-'a']++;
        }
        for(char c : tCharArray){
            charDiffCnt[c-'a']--;
        }
        for(int i : charDiffCnt){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}
