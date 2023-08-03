class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelSet = new HashSet<>();
        for(char jewel : jewels.toCharArray()) jewelSet.add(jewel);
        
        int cnt = 0;
        for(char stone : stones.toCharArray()){
            if(jewelSet.contains(stone)) cnt++;
        }
        return cnt;
    }
}