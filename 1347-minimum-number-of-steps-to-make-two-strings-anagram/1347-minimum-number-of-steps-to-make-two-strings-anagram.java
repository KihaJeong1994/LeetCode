class Solution {
    public int minSteps(String s, String t) {
        int answer = 0;
        Map<Character, Integer> sCnt = stringCnt(s);
        Map<Character, Integer> tCnt = stringCnt(t);
        for(Character c : tCnt.keySet()){
            int diff = tCnt.get(c) - sCnt.getOrDefault(c, 0);
            if(diff>0) answer+=diff;
        }
        return answer;
    }

    private static Map<Character, Integer> stringCnt(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        for(int i = 0; i< s.length(); i++){
            cnt.put(s.charAt(i), cnt.getOrDefault(s.charAt(i), 0)+1);
        }
        return cnt;
    }
}