class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> openClose = new HashMap<>();
        openClose.put('(',')');
        openClose.put('{','}');
        openClose.put('[',']');

        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(openClose.containsKey(c)){
                stack.push(c);
            }else {
                if(stack.isEmpty()) return false;
                Character open = stack.pop();
                if(openClose.get(open)!=c) return false;
            }
        }
        return stack.isEmpty();
    }
}