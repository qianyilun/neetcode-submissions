class Solution {
    int result = 0;
    
    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    int[] area = {1};
                    bfs(grid, i, j, area);
                    
                    result = Math.max(result, area[0]);
                }
            }
        }

        return result;
    }

    int[] deltaX = {1, -1, 0, 0};
    int[] deltaY = {0, 0, -1, 1};
    private void bfs(int[][] grid, int x, int y, int[] area) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int newX = curr[0] + deltaX[j];
                    int newY = curr[1] + deltaY[j];

                    if (inBoundary(newX, newY, grid) && grid[newX][newY] == 1) {
                        grid[newX][newY] = 0;
                        area[0]++;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }
    }

    private boolean inBoundary(int x, int y, int[][] board) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }
}
