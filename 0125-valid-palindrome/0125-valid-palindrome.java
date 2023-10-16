class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while (start<end){
            if (!Character.isLetterOrDigit(s.charAt(start))){
                start++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(end))){
                end--;
                continue;
            }
            String a = String.valueOf(s.charAt(start));
            String b = String.valueOf(s.charAt(end));
            if(a.equalsIgnoreCase(b)){
                start++;
                end--;
            }else {
                return false;
            }
        }
        return true;
    }
}