class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for(int i=2;i<=n-2;i++){
            if(!isPalindromic(n,i)){
                return false;
            }
        }
        return true;
    }
    
    private boolean isPalindromic(int n,int i){
        Stack<String> stack = new Stack<>();
        while(n>=i){
            stack.add(Integer.toString(n%i));
            n/=i;
        }
        stack.add(Integer.toString(n));
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return isPalindrome(sb.toString());
    }
    
    private boolean isPalindrome(String s){
        int length = s.length();
        for(int i=0;i<length/2;i++){
            if(s.charAt(i)!=s.charAt(length-1-i)){
                return false;
            }
        }
        return true;
    }
}