class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for(String sentence : sentences){
            max = Math.max(sentence.split(" ").length, max);
        }
        return max;
    }
}