class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        List<List<String>> answerList = new ArrayList<>();
        for(String str : strs){
            String sorted = getKey(str);
            List<String> anagramList = map.getOrDefault(sorted,new ArrayList<>());
            anagramList.add(str);
            map.put(sorted, anagramList);
        }
        map.forEach((key,val)->answerList.add(val));
        return answerList;
    }

    private static String getKey(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;
    }

    
}