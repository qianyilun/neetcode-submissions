class Solution {
    boolean result = false;
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char temp = board[i][j];

                if (temp == word.charAt(0)) {
                    board[i][j] = '#';
                    helper(board, i, j, word, 0);
                    board[i][j] = temp;
                }
            }
        }
        return result;
    }

    int[] deltaX = {0, 0, 1, -1};
    int[] deltaY = {1, -1, 0, 0};

    private void helper(char[][] board, int x, int y, String word, int index) {
        if (result) {
            return;
        }
        if (index >= word.length() - 1) {
            result = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int newX = x + deltaX[i];
            int newY = y + deltaY[i];

            if (inBoard(board, newX, newY)
                    && word.charAt(index + 1) == board[newX][newY]
                    && board[newX][newY] != '#') {
                char temp = board[newX][newY];
                board[newX][newY] = '#';
                helper(board, newX, newY, word, index + 1);
                board[newX][newY] = temp;
            }
        }
    }

    private boolean inBoard(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }
}
