class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for(char c : chars){
            int idx = c-'a';
            if(node.childNodes[idx]==null){
                node.childNodes[idx] = new TrieNode();
            }
            node = node.childNodes[idx];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for(char c : chars){
            int idx = c-'a';
            if(node.childNodes[idx]==null){
                return false;
            }else{
                node = node.childNodes[idx];
            }
        }
        return node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        char[] chars = prefix.toCharArray();
        for(char c : chars){
            int idx = c-'a';
            if(node.childNodes[idx]==null){
                return false;
            }else{
                node = node.childNodes[idx];
            }
        }
        return true;
    }

    private static class TrieNode{
        TrieNode[] childNodes;
        boolean isEnd;
        TrieNode(){
            childNodes = new TrieNode[26];
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