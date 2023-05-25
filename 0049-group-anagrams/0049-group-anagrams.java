class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        List<List<String>> answerList = new ArrayList<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            List<String> anagramList = map.get(sorted);
            if(anagramList==null){
                anagramList = new ArrayList<>();
                anagramList.add(str);
                map.put(sorted, anagramList);
            }else{
                anagramList.add(str);
            }
        }
        map.forEach((key,val)->answerList.add(val));
        return answerList;
    }

    
}