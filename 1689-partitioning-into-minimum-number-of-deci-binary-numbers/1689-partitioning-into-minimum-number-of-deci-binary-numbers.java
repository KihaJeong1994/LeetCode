class Solution {
    public int minPartitions(String n) {
        char answer = '0';
        for(int i=0; i<n.length(); i++){
            char c = n.charAt(i);
            if(c=='9'){
                return 9;
            }else{
                if(c>answer){
                    answer = c;
                }
            }
        }
        return Integer.parseInt(answer+"");
    }
}