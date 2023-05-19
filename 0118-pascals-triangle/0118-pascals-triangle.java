class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answerList = new ArrayList<>();
        answerList.add(Arrays.asList(1));
        for(int i=1; i< numRows; i++){
            List<Integer> answer = new ArrayList<>();
            answer.add(1);
            for(int j=1; j<=i-1; j++){
                answer.add(answerList.get(i-1).get(j-1)+answerList.get(i-1).get(j));
            }
            answer.add(1);
            answerList.add(answer);
        }
        return answerList;
    }
}