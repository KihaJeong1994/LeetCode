class Solution {
    public String makeSmallestPalindrome(String s) {
        // egcfe
        //  gcf
        //  fcf
        //   c
        int start = 0;
        int end = s.length()-1;
        char[] charArr = s.toCharArray();
        while(start<end){
            if(charArr[start]<charArr[end]){
                charArr[end] = charArr[start];
            }else {
                charArr[start] = charArr[end];
            }
            start++;
            end--;
        }
        return new String(charArr);
    }
}