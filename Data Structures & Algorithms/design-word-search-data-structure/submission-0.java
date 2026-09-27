class WordDictionary {
    WordDictionary[] wordDictionary = new WordDictionary[26];
    boolean isEnd = false;

    public WordDictionary() {

    }

    public void addWord(String word) {
        WordDictionary dummy = this;
        for(char c : word.toCharArray()) {
            int index = c - 'a';
            if (dummy.wordDictionary[index] == null) {
                dummy.wordDictionary[index] = new WordDictionary();
            }
            dummy = dummy.wordDictionary[index];
        }

        dummy.isEnd = true;
    }

    public boolean search(String word) {
        return helper(word, 0, this);
    }

    private boolean helper(String word, int index, WordDictionary start) {
        if (index >= word.length()) {
            return start.isEnd;
        }
        
        char c = word.charAt(index);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                WordDictionary dummy = start.wordDictionary[i];
                if (dummy == null) {
                    continue;
                }
                if (helper(word, index + 1, dummy)) {
                    return true;
                }
            }
            
            return false;
        } else {
            if (start.wordDictionary[c - 'a'] == null) {
                return false;
            } else {
                return helper(word, index + 1, start.wordDictionary[c - 'a']);
            }
        }
    }
}