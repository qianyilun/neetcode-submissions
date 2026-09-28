class Solution {
    boolean result = false;
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                StringBuilder sb = new StringBuilder();

                helper(board, i, j, word, sb, 0);

                if (result) {
                    return true;
                }
            }
        }
        return result;
    }

    private void helper(char[][] board, int x, int y, String word, StringBuilder sb, int index) {
        if (word.equals(sb.toString())) {
            result = true;
            return;
        }

        if (sb.length() > word.length()) {
            return;
        }

        sb.append(board[x][y]);

        if (inBoard(board, x + 1, y)) {
            helper(board, x + 1, y, word, sb, index+1);
        }

        if (inBoard(board, x - 1, y)) {
            helper(board, x - 1, y, word, sb, index+1);
        }
        if (inBoard(board, x, y + 1)) {
            helper(board, x, y + 1, word, sb, index+1);
        }
        if (inBoard(board, x, y - 1)) {
            helper(board, x, y - 1, word, sb, index+1);
        }

        sb.deleteCharAt(sb.length() - 1);
    }

    private boolean inBoard(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }
}
