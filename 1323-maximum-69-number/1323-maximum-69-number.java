class Solution {
    public int maximum69Number (int num) {
        int length = (int) Math.log10(num) + 1;
        int newNum = num;
        while(newNum>0){
            int now = newNum / (int) Math.pow(10,length-1);
            if(now!=9){
                num += 3*Math.pow(10,length-1);
                return num;
            }
            newNum = newNum % (int) Math.pow(10,length-1);
            length--;
        }
        return num;
    }
}