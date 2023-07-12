class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> answer = new ArrayList<>();
        boolean[] isFromExist = new boolean[n];
        for(List<Integer> edge : edges){
            int to = edge.get(1);
            isFromExist[to] = true;
        }
        for(int i=0; i<n;i++){
            if(!isFromExist[i]){
                answer.add(i);
            }
        }
        return answer;
    }
}