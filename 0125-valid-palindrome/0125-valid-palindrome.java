class Solution {
    public boolean isPalindrome(String s) {
        s= s.toLowerCase();
         StringBuilder sb = new StringBuilder();
         for(int i=0; i<s.length();i++){
             char c = s.charAt(i);
             if((c >=97 && c <=122) || (c >=48 && c <=57)){
                 sb.append(c);
             }
         }
         s = sb.toString();
         for(int i=0; i<s.length()/2;i++){
             if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                 return false;
             }
         }
        return true;
    }
}