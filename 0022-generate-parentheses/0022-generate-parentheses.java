class Solution {
    List<String> answerList = new ArrayList<>();
    int globalN;
    public List<String> generateParenthesis(int n) {
        globalN = n;
        recFunc("(",1,1,0);
        return answerList;
    }

    private void recFunc(String s , int length, int leftCnt, int rightCnt) {
        if(length == globalN*2){
            answerList.add(s);
        }else {
            if(leftCnt>rightCnt) recFunc(s+")",length+1,leftCnt,rightCnt+1);
            if(leftCnt<globalN) recFunc(s+"(",length+1,leftCnt+1,rightCnt);
        }
    }
}