class Solution {
    private List<List<Integer>> answerList = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        search(0,graph,path);
        return answerList;
    }
    
    void search(int i, int[][] graph, List<Integer> path){
        path.add(i);
        if(i==graph.length-1){
            answerList.add(new ArrayList<>(path));
        }else{
            for(int j : graph[i]){
                search(j,graph, path);
                path.remove(path.size()-1);
            }
        }
        
    }
}