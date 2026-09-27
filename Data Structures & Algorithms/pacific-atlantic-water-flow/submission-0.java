class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[][] copy = new int[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                copy[i][j] = heights[i][j];
            }
        }

        boolean[][] visited1 = new boolean[heights.length][heights[0].length];
        Queue<int[]> queue1 = new LinkedList<>();

        for (int i = 0; i < heights[0].length; i++) {
            queue1.offer(new int[]{0, i});
            visited1[0][i] = true;
        }
        for (int i = 0; i < heights.length; i++) {
            queue1.offer(new int[]{i, 0});
            visited1[i][0] = true;
        }

        bfs(queue1, heights, visited1);

        boolean[][] visited2 = new boolean[heights.length][heights[0].length];
        Queue<int[]> queue2 = new LinkedList<>();

        for (int i = 0; i < copy[0].length; i++) {
            queue2.offer(new int[]{copy.length - 1, i});
            visited2[copy.length - 1][i] = true;
        }
        for (int i = 0; i < copy.length; i++) {
            queue2.offer(new int[]{i, copy[0].length - 1});
            visited2[i][copy[0].length - 1] = true;
        }

        bfs(queue2, copy, visited2);

        List<List<Integer>> finalResult = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (visited1[i][j] && visited2[i][j]) {
                    List<Integer> coor = new ArrayList<>();
                    coor.add(i);
                    coor.add(j);
                    finalResult.add(coor);
                }
            }
        }

        return finalResult;
    }

    int[] deltaX = {0, 0, 1, -1};
    int[] deltaY = {1, -1, 0, 0};
    private void bfs(Queue<int[]> queue, int[][] heights, boolean[][] visited) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int newX = curr[0] + deltaX[j];
                    int newY = curr[1] + deltaY[j];

                    // can flow from
                    if (inBoundary(newX, newY, heights)
                            && !visited[newX][newY]
                            && heights[newX][newY] >= heights[curr[0]][curr[1]]) {
                        visited[newX][newY] = true;
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
