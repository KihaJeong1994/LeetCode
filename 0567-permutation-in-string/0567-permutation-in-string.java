class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l = 0;
        int r = 0;
        int s1Length = s1.length();
        int s2Length = s2.length();
        char[] s1CharArray = s1.toCharArray();
        char[] s2CharArray = s2.toCharArray();
        int[] cnts = new int[26];
        for(char c : s1CharArray){
            cnts[c-'a']++;
        }

        
        int s1Cnt = s1Length;
        while(r<s2Length){
            char c = s2CharArray[r];
            if(cnts[c-'a']>0){
                cnts[c-'a']--;
                s1Cnt--;
                r++;
            }else{
                cnts[s2CharArray[l]-'a']++;
                s1Cnt++;
                l++;
            }
            if(s1Cnt==0){
                return true;
            }
        }
        
        
        return false;  
    }
}