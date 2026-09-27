class Solution {
    public int countComponents(int n, int[][] edges) {
        // build graph
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int v = edge[0];
            int u = edge[1];

            List<Integer> l1 = graph.get(v);
            List<Integer> l2 = graph.get(u);

            l1.add(u);
            l2.add(v);

            graph.put(v, l1);
            graph.put(u, l2);
        }

        // traverse each node with dfs
        boolean[] visited = new boolean[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            dfs(graph, i, visited);

            result++;
        }

        return result;
    }

    private void dfs(Map<Integer, List<Integer>> graph, int node, boolean[] visited) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }
}
