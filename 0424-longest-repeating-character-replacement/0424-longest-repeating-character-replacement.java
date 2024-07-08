class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int answer = 0;
        int[] charCnts = new int[26];
        char[] sCharArray = s.toCharArray();
        // here is what I want to keep track of
        // 1. total length of String that I'm checking (r-l+1)
        // 2. the letter with the most cnt
        // if 1-2 > k, move left
        charCnts[sCharArray[l]-'A']+=1;
        while(r<sCharArray.length){
            int strLength = r-l+1;
            char mostChar = getMostChar(charCnts,l,r);
            int mostCharCnt = charCnts[mostChar-'A'];
            
            if(strLength - mostCharCnt > k){
                charCnts[sCharArray[l]-'A']-=1;
                l++;
            }else{
                answer = Math.max(answer, strLength);
                r++;
                if(r<sCharArray.length) charCnts[sCharArray[r]-'A']+=1;
                
            }
        }
        answer = Math.max(answer, r-l);
        return answer;
    }

    private char getMostChar(int[] charCnts , int l, int r){
        int index = 0;
        int maxCnt = 0;
        for(int i=0; i<26; i++){
            int charCnt = charCnts[i];
            if(charCnt>maxCnt){
                maxCnt = charCnt;
                index = i;
            }
        }
        return (char)(index+'A');
    }
}