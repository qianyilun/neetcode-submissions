class Solution {
    public int countComponents(int n, int[][] edges) {
// build edge graph map
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            List<Integer> adjacentForNode1 = graph.getOrDefault(node1, new ArrayList<>());
            List<Integer> adjacentForNode2 = graph.getOrDefault(node2, new ArrayList<>());

            adjacentForNode1.add(node2);
            adjacentForNode2.add(node1);

            graph.put(node1, adjacentForNode1);
            graph.put(node2, adjacentForNode2);
        }

        for (int i = 0; i < n; i++) {
            if (!graph.containsKey(i)) {
                graph.put(i, new ArrayList<>());
            }
        }

        // traverse each node with dfs to count component components
        boolean[] visited = new boolean[n];
        int completedComponents = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            List<Integer> connectedComponents = new ArrayList<>();
            dfs(visited, connectedComponents, i, graph);

            
            completedComponents++;
        }

        return completedComponents;
    }

    private void dfs(boolean[] visited, List<Integer> connectedComponents, int node, Map<Integer, List<Integer>> graph) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;
        connectedComponents.add(node);
        
        for (int neighbour : graph.get(node)) {
            if (!visited[neighbour]) {
                dfs(visited, connectedComponents, neighbour, graph);
            }
        }
    }
}
