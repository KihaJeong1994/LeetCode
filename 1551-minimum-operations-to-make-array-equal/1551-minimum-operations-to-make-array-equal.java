class Solution {
    public int minOperations(int n) {
        int k = n/2;
        if(n%2==0){
            return k*k;
        }else{   
            return k*(k+1);
        }
            
    }
}