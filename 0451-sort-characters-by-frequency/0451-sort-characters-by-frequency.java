class Solution {
    public String frequencySort(String s) {
        // 1. count char in s
        Map<Character,Integer> cntMap = new HashMap<>();
        Character[] chars = new Character[s.length()];
        for(int i=0; i<s.length();i++){
            Integer cnt = cntMap.getOrDefault(s.charAt(i), 0);
            cntMap.put(s.charAt(i),++cnt);
            chars[i] = s.charAt(i);
        }
        // 2. sort char[] by count desc
        Arrays.sort(chars,(c1,c2)-> {
            if(cntMap.get(c2).equals(cntMap.get(c1))){
                return c2.compareTo(c1);
            }
            return cntMap.get(c2) - cntMap.get(c1);
        });

        // 3. char[] to String
        StringBuilder sb = new StringBuilder();
        for(char c : chars){
            sb.append(c);
        }
        return sb.toString();
    }
}