class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int start = 1;
        int end = answerKey.length();
        int max = 1;
        while(start<=end){
            int maxSize = (start+end)/2;
            int cntT = 0;
            int cntF = 0;
            boolean isValid = false;
            // check if maxSize Substring is valid
            for(int i=0; i<answerKey.length()-maxSize+1; i++){
                if(i==0){
                    for(int j=0; j<maxSize;j++){
                        if(answerKey.charAt(j)=='T'){
                            cntT++;
                        } else{
                            cntF++;
                        }
                    }
                }else{
                    // add count last one and minus count first one
                    if(answerKey.charAt(i-1)=='T'){
                        cntT--;
                    } else{
                        cntF--;
                    }
                    if(answerKey.charAt(i+maxSize-1)=='T'){
                        cntT++;
                    } else{
                        cntF++;
                    }
                }
                // if maxSize Substring is valid
                if(Math.min(cntT,cntF)<=k){
                    isValid = true;
                    break;
                }
            }
            if(isValid){
                start = maxSize + 1;
                max = maxSize;
            }else{
                end = maxSize-1;
            }

        }
        return max;

    }
}