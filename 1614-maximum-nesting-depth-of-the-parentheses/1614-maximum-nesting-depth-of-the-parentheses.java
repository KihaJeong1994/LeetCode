class Solution {
    public int maxDepth(String s) {
        int maxD = 0;
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for(char c : chars){
            if(c=='('){
                stack.push(c);
                maxD = Math.max(stack.size(),maxD);
            }else if(c==')'){
                stack.pop();
            }
        }
        return maxD;
    }
}