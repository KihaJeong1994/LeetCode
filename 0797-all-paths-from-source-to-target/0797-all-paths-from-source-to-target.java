class Solution {
    private List<List<Integer>> answerList = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Stack<Integer> path = new Stack<>();
        search(0,graph,path);
        return answerList;
    }
    
    void search(int i, int[][] graph, Stack<Integer> path){
        path.push(i);
        if(i==graph.length-1){
            List<Integer> l = new ArrayList<>();
            path.forEach(p->l.add(p));
            answerList.add(l);
        }else{
            for(int j : graph[i]){
                search(j,graph, path);
                path.pop();
            }
        }
        
    }
}