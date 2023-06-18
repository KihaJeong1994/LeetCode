class Solution {
    public int minPartitions(String n) {
        int answer = 1;
        for(int i=0; i<n.length(); i++){
            int toInt = Integer.parseInt(n.charAt(i)+"");
            if(toInt>answer){
                answer = toInt;
            }
        }
        return answer;
    }
}