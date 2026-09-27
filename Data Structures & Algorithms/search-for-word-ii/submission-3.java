class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = toTrie(words);
        List<String> result = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (trie.tries[board[i][j] - 'a'] != null) {
                    char temp = board[i][j];
                    board[i][j] = '#';
                    dfs(board, trie, i, j, result, new StringBuilder("" + temp));
                    board[i][j] = temp;
                }
            }
        }

        return result;
    }

    int[] deltaX = {1, -1, 0, 0};
    int[] deltaY = {0, 0, 1, -1};

    private void dfs(char[][] board, Trie trie, int x, int y, List<String> result, StringBuilder sb) {
        // quit
        Trie searchResult = trie.search(sb.toString()); 
        if (searchResult == null) {
            return;
        }
        if (searchResult.isEnd) {
            result.add(sb.toString());
            searchResult.isEnd = false;
        }

        // general
        for (int i = 0; i < 4; i++) {
            int newX = x + deltaX[i];
            int newY = y + deltaY[i];

            if (inBoundary(newX, newY, board) && board[newX][newY] != '#') {
                sb.append(board[newX][newY]);
                if (trie.hasPrefix(sb.toString())) {
                    char temp = board[newX][newY];
                    board[newX][newY] = '#';
                    dfs(board, trie, newX, newY, result, sb);
                    board[newX][newY] = temp;
                }
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private boolean inBoundary(int x, int y, char[][] board) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }

    private Trie toTrie(String[] words) {
        Trie trie = new Trie();
        for (String s : words) {
            trie.insert(s);
        }

        return trie;
    }

    class Trie {
        Trie[] tries = new Trie[26];
        boolean isEnd = false;

        public Trie() {
        }

        public void insert(String word) {
            Trie dummy = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';

                if (dummy.tries[index] == null) {
                    dummy.tries[index] = new Trie();
                }

                dummy = dummy.tries[index];
            }

            dummy.isEnd = true;
        }

        public boolean hasPrefix(String word) {
            Trie dummy = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';

                if (dummy.tries[index] == null) {
                    return false;
                }

                dummy = dummy.tries[index];
            }

            return true;
        }

        public Trie search(String word) {
            Trie dummy = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';

                if (dummy.tries[index] == null) {
                    return null;
                }

                dummy = dummy.tries[index];
            }

            return dummy;
        }
    }
}
