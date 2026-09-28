class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int[] time : times) {
            int source = time[0];
            int target = time[1];
            int cost = time[2];

            List<int[]> neighbors = map.getOrDefault(source, new ArrayList<>());
            int[] neighborInfo = {target, cost};
            neighbors.add(neighborInfo);

            map.put(source, neighbors);
        }

        Set<Integer> visited = new HashSet<>();
        visited.add(k);

        dfs(map, visited, 0, n, k, times);

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private void dfs(Map<Integer, List<int[]>> map, Set<Integer> visited, int cost, int n, int node, int[][] times) {
        if (visited.size() == n) {
            result = Math.min(result, cost);
            return;
        }

        for (int[] neighborInfo : map.getOrDefault(node, new ArrayList<>())) {
            int next = neighborInfo[0];
            int toCost = neighborInfo[1];

            if (!visited.contains(next)) {
                visited.add(next);
                dfs(map, visited, cost + toCost, n, next, times);
                // visited.remove(next);
            }
        }
    }

    int result = Integer.MAX_VALUE;
}
