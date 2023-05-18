class Solution {
    public List<String> generateParenthesis(int n) {
        Set<String> answerSet = new HashSet<>();
        if( n == 1){
            answerSet.add("()");
        }else {
            for(int i=1;i<=n-1;i++){
                for(String s1 : generateParenthesis(i)){
                    for(String s2 : generateParenthesis(n-i)){
                        answerSet.add(s1+s2);
                    }
                    if(i==n-1)answerSet.add("("+s1+")");
                }
            }
        }
        return answerSet.stream().collect(Collectors.toList());
    }
}