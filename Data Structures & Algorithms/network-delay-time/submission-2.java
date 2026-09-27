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

        // int[] 存 [node, totalCostToHere]
        Queue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));

        int[] start = {k, 0};
        heap.offer(start);

        while (!heap.isEmpty()) {
            int[] curr = heap.poll();

            int cost = curr[1];
            int node = curr[0];

            if (visited.contains(node)) {
                continue;
            }

            visited.add(node);

            if (visited.size() == n) {
                return cost;
            }

            List<int[]> neighbors = map.getOrDefault(node, new ArrayList<>());

            for (int[] neighbor : neighbors) {
                int next = neighbor[0];
                int nextCost = neighbor[1];

                if (!visited.contains(next)) {
                    heap.offer(new int[]{next, nextCost + cost});
                }
            }
        }

        return -1;
    }
}
