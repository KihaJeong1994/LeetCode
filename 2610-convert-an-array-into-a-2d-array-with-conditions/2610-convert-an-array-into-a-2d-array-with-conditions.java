class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        // each row contains distinct integer & minimize => number of row = max cnt of num in nums
        // if num not exists in 2D array -> put it in first row(if no row, create one)
        // if num exists in 2D array -> put it in the next row
        // -> need data structure to store the last row of certain num -> Map<Integer,Integer>
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        Map<Integer,Integer> numLastRow = new HashMap<>();
        
        for(int num : nums){
            if(!numLastRow.containsKey(num)){
                answer.get(0).add(num);
                numLastRow.put(num,0);
            }else{
                int lastRow = numLastRow.get(num);
                if(answer.size()<lastRow+2) answer.add(new ArrayList<>());
                answer.get(lastRow+1).add(num);
                numLastRow.put(num,lastRow+1);
            }
        }
        return answer;
    }
}