class Solution {
    public List<Integer> partitionLabels(String s) {
        // int[] lastIdxs : lastIdx of char in String s
        // ababcbacadefegdehijhklij
        // a : 8, b : 5, c: 7 , d : 14, e : 15, f : 11
        
        // Loop s with char s[i]
        // int start = 0
        // int end = 0
        // end = Math.max(lastIdxs[s[i]-'a'], end)
        // if i == end -> add (end-start+1) to answer, start = end+1
        
        List<Integer> answer = new ArrayList<>();
        int[] lastIdxs = new int[26];
        for(int i=0; i<s.length(); i++){
            lastIdxs[s.charAt(i)-'a'] = i;
        }
        
        int start = 0;
        int end = 0;
        for(int i=0; i<s.length(); i++){
            end = Math.max(lastIdxs[s.charAt(i)-'a'], end);
            if(i==end){
                answer.add(end-start+1);
                start = end+1;
            }
        }
        
        return answer;
        
    }
}