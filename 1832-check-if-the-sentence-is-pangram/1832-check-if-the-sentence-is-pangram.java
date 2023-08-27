class Solution {
    public boolean checkIfPangram(String sentence) {
        int cnt = 0;
        boolean[] exists = new boolean[26];
        char[] charArray = sentence.toCharArray();
        for(char c : charArray){
            if(!exists[c-'a']){
                exists[c-'a'] = true;
                cnt++;
            }
            if(cnt==26) return true;
        }
        return false;
    }
}