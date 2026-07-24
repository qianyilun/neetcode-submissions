class Solution {
    public static boolean isValidSudoku(char[][] board) {
        // x
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];

                if (c == '.') {
                    continue;
                }

                if (set.contains(c)) {
                    return false;
                }
                set.add(c);
            }
        }

        // y
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];

                if (c == '.') {
                    continue;
                }

                if (set.contains(c)) {
                    return false;
                }
                set.add(c);
            }
        }

        // inner check
        if (!passInnerCheck(0, 2, 0, 2, board)) {
            return false;
        }
        if (!passInnerCheck(0, 2, 3, 5, board)) {
            return false;
        }
        if (!passInnerCheck(0, 2, 6, 8, board)) {
            return false;

        }
        if (!passInnerCheck(3, 5, 0, 2, board)) {
            return false;

        }
        if (!passInnerCheck(3, 5, 3, 5, board)) {
            return false;

        }
        if (!passInnerCheck(3, 5, 6, 8, board)) {
            return false;

        }
        if (!passInnerCheck(6, 8, 0, 2, board)) {
            return false;

        }
        if (!passInnerCheck(6, 8, 3, 5, board)) {
            return false;

        }
        if (!passInnerCheck(6, 8, 6, 8, board)) {
            return false;
        }

        return true;
    }

    private static boolean passInnerCheck(int startX, int endX, int startY, int endY, char[][] board) {
        Set<Character> set = new HashSet<>();

        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                char c = board[i][j];

                if (c == '.') {
                    continue;
                }

                if (set.contains(c)) {
                    return false;
                }
                set.add(c);
            }
        }

        return true;
    }
}
