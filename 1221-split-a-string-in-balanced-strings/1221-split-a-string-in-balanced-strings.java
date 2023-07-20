class Solution {
    public int balancedStringSplit(String s) {
        // Stack
        // L R -> empty -> ++
        // L L R R -> empty -> ++
        // -> int stack L : -1 R : 1
        // L R 0 -> ++
        // R R L R L L -> ++
        
        int answer = 0;
        int stack = 0;
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            if(c=='L'){
                stack--;
            }else{
                stack++;
            }
            if(stack==0){
                answer ++;
            }
        }
        return answer;
    }
}