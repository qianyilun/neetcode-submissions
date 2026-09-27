class PrefixTree {

    public PrefixTree() {
         
    }

    PrefixTree[] trie = new PrefixTree[26];
    boolean isEnd = false;

    public void insert(String word) {
        PrefixTree dummy = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (dummy.trie[index] == null) {
                dummy.trie[index] = new PrefixTree();
            }
            dummy = dummy.trie[index];
        }
        
        dummy.isEnd = true;
    }

    public boolean search(String word) {
        PrefixTree dummy = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (dummy.trie[index] == null) {
                return false;
            }
            dummy = dummy.trie[index];
        }

        return dummy.isEnd;
    }

    public boolean startsWith(String prefix) {
        PrefixTree dummy = this;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (dummy.trie[index] == null) {
                return false;
            }
            dummy = dummy.trie[index];
        }
        
        return true;
    }
}
