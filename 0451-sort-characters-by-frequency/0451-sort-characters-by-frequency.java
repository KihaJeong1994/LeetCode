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
        
        PriorityQueue<Character> pq = new PriorityQueue<>((c1,c2)->{
            if(cntMap.get(c2).equals(cntMap.get(c1))){
                return c2.compareTo(c1);
            }
            return cntMap.get(c2) - cntMap.get(c1);
        });
        for(int i=0; i<s.length();i++){
            pq.add(s.charAt(i));
        }

        
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){
            sb.append(pq.poll());
        }
        return sb.toString();
    }
}