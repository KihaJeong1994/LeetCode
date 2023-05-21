public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int answer = 0;
        if(n<0){
          n += Math.pow(2,31);  
          answer++;
        } 
        while(n!=0){
            answer += n%2;
            n /= 2;
        }
        return answer;
    }
}