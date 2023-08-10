class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        int wordCnt = words.length;
        String[] newWords = new String[wordCnt];
        StringBuilder sb = new StringBuilder();
        for(String word : words){
            int index = word.charAt(word.length()-1)-(int)'1';
            newWords[index] = word.substring(0,word.length()-1);
        }
        for(String word : newWords){
            sb.append(word);
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}