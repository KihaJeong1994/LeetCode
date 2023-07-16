class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int len = 1;
        int start = 0;
        int end = start + len -1;
        int strLen = answerKey.length();

        int cntT = 0;
        int cntF = 0;
        while (end<=strLen-1){
            if(answerKey.charAt(end)=='T'){
                cntT++;
            }else {
                cntF++;
            }
            int minCnt = Math.min(cntT, cntF);
            end++;
            if(minCnt>k){
                start++;
                if(answerKey.charAt(start-1)=='T'){
                    cntT--;
                }else {
                    cntF--;
                }
            }else {
                len = Math.max(len, cntT+cntF);
            }
        }
        return len;
    }
}