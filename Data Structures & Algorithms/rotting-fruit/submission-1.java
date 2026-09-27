class Solution {
    int mins = 0;
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    grid[i][j] = 0;
                }
            }
        }

        bfs(grid, queue);

        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return Math.max(mins - 1, 0);
        }

        return -1;
    }

    int[] deltaX = {-1, 1, 0, 0};
    int[] deltaY = {0, 0, 1, -1};

    private void bfs(int[][] grid, Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int newX = curr[0] + deltaX[j];
                    int newY = curr[1] + deltaY[j];

                    if (inBoundary(grid, newX, newY) && grid[newX][newY] == 1) {
                        grid[newX][newY] = 0;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
            mins++;
        }
    }

    private boolean inBoundary(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
