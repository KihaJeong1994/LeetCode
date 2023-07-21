class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        // I have to group people by groupSizes[i] -> Map to group people
        // Map<Integer, List<Integer>> is enough
        // if map contains not groupSizes[i] -> put list with groupSizes[i]
        // if map contains groupSizes[i] 
        // put groupSizes[i] in list
        
        // after if groupSizes[i] list size == groupSizes[i] -> put it in answerList and remove groupSizes[i]
        
        List<List<Integer>> answer = new ArrayList<>();
        Map<Integer, List<Integer>> groupSizeList = new HashMap<>();
        int length = groupSizes.length;
        for(int i=0; i< length; i++){
            int groupSize = groupSizes[i];
            if(!groupSizeList.containsKey(groupSize)){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                groupSizeList.put(groupSize, list);
            }else{
                groupSizeList.get(groupSize).add(i);
            }
            if(groupSizeList.get(groupSize).size()==groupSize){
                answer.add(groupSizeList.get(groupSize));
                groupSizeList.remove(groupSize);
            } 
        }
        return answer;
        
    }
}