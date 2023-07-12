class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> answer = new ArrayList<>();
        List<List<Integer>> toFrom = new ArrayList<>();
        for(int i=0; i<n;i++){
            toFrom.add(new ArrayList<>());
        }
        for(List<Integer> edge : edges){
            int from = edge.get(0);
            int to = edge.get(1);
            toFrom.get(to).add(from);
        }
        for(int i=0; i<n;i++){
            List<Integer> tF = toFrom.get(i);
            if(tF.size()==0){
                answer.add(i);
            }
        }
        return answer;
    }
}