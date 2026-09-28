class Solution {
    public void solve(char[][] board) {
        char[][] result = new char[board.length][board[0].length];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[]{i, 0});
                result[i][0] = 'O';
            }
            if (board[i][board[0].length - 1] == 'O') {
                queue.offer(new int[]{i, board[0].length - 1});
                result[i][board[0].length - 1] = 'O';
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                queue.offer(new int[]{0, i});
                result[0][i] = 'O';
            }
            if (board[board.length - 1][i] == 'O') {
                queue.offer(new int[]{board.length - 1, i});
                result[board.length - 1][i] = 'O';
            }
        }

        int[] deltaX = {1, -1, 0, 0};
        int[] deltaY = {0, 0, 1, -1};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int newX = curr[0] + deltaX[j];
                    int newY = curr[1] + deltaY[j];

                    if (inBoundary(board, newX, newY) && !isEdge(board, newX, newY) && board[newX][newY] == 'O') {
                        board[newX][newY] = '1';
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (result[i][j] != 'O') {
                    result[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = result[i][j];
            }
        }
    }

    private boolean inBoundary(char[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
    
    private boolean isEdge(char[][] grid, int x, int y) {
        return x == 0 || x == grid.length - 1 || y == 0 || y == grid[0].length - 1;
    }
}
