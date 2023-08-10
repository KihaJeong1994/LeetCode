class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        Arrays.sort(words,
                (w1,w2)->Integer.parseInt(String.valueOf(w1.charAt(w1.length()-1))) - Integer.parseInt(String.valueOf(w2.charAt(w2.length()-1)))
        );
        for(int i=0; i<words.length; i++){
            String word = words[i];
            words[i] = word.substring(0, word.length()-1);
        }
        s = String.join(" ",words);
        return s;
    }
}