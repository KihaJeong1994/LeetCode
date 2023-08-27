class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        char[] charArray = sentence.toCharArray();
        for(char c : charArray){
            set.add(c);
        }
        return set.size()==26;
    }
}