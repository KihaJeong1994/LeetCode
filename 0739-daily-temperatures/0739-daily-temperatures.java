class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // compare each day with every other day => O(n**2)
        // if temperatures[i] < temperatures[i+1] => answer[i] = 1, no problem
        // else I can not decide the answer day now, so I put it in some data structure
        // when I get to the i that satisfy temperatures[i] < temperatures[i+1]
        // answer[i] = 1, and then compare it with the last element of the data structure, let's call it l
        // if l < answer[i+1] => answer of l's index = i+1 - l and get l out of the structure
        // in this way, every element that is smaller than answer[i+1] will be get out of that data structure
        // only left the bigger one => the data will be sorted in decreasing order
        // and stack is the proper data structure, since the smaller one(which will be recent one) should be out first
        
        int tl = temperatures.length;
        int[] answer = new int[tl];
        // 1. I need Stack that store index and value
        Deque<TemperatureWithIndex> stack = new ArrayDeque<>();
        
        for(int i=0; i<tl-1; i++){
            if(temperatures[i]<temperatures[i+1]){
                answer[i] = 1;
                TemperatureWithIndex lastTmp = stack.peekLast();
                while(lastTmp != null){
                    if(lastTmp.temp<temperatures[i+1]){
                        int idx = stack.pollLast().i;
                        answer[idx] = i+1 - idx;
                        lastTmp = stack.peekLast();
                    }else{
                        break;
                    }
                }
            }else{
                stack.offer(new TemperatureWithIndex(i,temperatures[i]));
            }
            
        }
        return answer;
    }
    
    private static class TemperatureWithIndex{
        int i;
        int temp;
        TemperatureWithIndex(int i, int temp){
            this.i = i;
            this.temp = temp;
        }
    }
}