class Solution {
    Set<String> set = new HashSet<>();
    boolean[] visited;
    StringBuilder sb = new StringBuilder();

    public int numTilePossibilities(String tiles) {
        visited = new boolean[tiles.length()];
        recFunc(0,tiles);
        return set.size();
    }

    void recFunc(int len, String tiles){
        if(len<tiles.length()){
            for(int j=0; j<tiles.length();j++){
                if(!visited[j]){
                    visited[j] = true;
                    sb.append(tiles.charAt(j));
                    set.add(sb.toString());
                    recFunc(len+1,tiles);
                    sb.deleteCharAt(len);
                    visited[j] = false;
                }
            }
        }
    }
}