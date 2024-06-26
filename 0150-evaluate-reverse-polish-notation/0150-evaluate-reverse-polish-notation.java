class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String token : tokens){
            if("+-*/".contains(token)){
                // if token is operator
                // poll 2 token and calculate
                Integer secondNum = stack.pollLast();
                Integer firstNum = stack.pollLast();
                int result = 0;
                if("+".equals(token)){
                    result = firstNum+secondNum;
                }else if("-".equals(token)){
                    result = firstNum-secondNum;
                }else if("*".equals(token)){
                    result = firstNum*secondNum;
                }else {
                    result = firstNum/secondNum;
                }
                stack.offer(result);
                // put it back to stack
                
            }else {
                // put in stack
                stack.offer(Integer.parseInt(token));
            }
        }
        return stack.pollLast();
    }
}