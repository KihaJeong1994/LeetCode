class Trie {
    TrieNode head;
    public Trie() {
        this.head = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = head;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            TrieNode t = node.trieNodes.getOrDefault(c,new TrieNode());
            node.trieNodes.put(c,t);
            node = node.trieNodes.get(c);
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode node = head;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(node.trieNodes.get(c)!=null){
                node = node.trieNodes.get(c);    
            }else{
                return false;
            }
        }
        return node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = head;
        for(int i=0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if(node.trieNodes.get(c)!=null){
                node = node.trieNodes.get(c);    
            }else{
                return false;
            }
        }
        return true;
    }
    
    static class TrieNode{
        Map<Character, TrieNode> trieNodes;
        boolean isEnd;
        TrieNode(){
            this.trieNodes = new HashMap<>();
            this.isEnd = false;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */