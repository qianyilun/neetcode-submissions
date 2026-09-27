class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        int[] deltaX = {0, 0, 1, -1};
        int[] deltaY = {1, -1, 0, 0};

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int newX = curr[0] + deltaX[j];
                    int newY = curr[1] + deltaY[j];
                    
                    if (inBoundary(newX, newY, grid) && grid[newX][newY] == Integer.MAX_VALUE) {
                        grid[newX][newY] = Math.min(grid[newX][newY], level);
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
            
        }
    }

    private boolean inBoundary(int x, int y, int[][] grid) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
