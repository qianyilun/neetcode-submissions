class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parents = new int[edges.length + 1]; // 因为节点数是 1 ~ n, 所以要 +1

        // init
        for (int i = 1; i < parents.length; i++) {
            parents[i] = i;
        }

        for (int[] edge : edges) {
            int curr = edge[0];
            int neighbour = edge[1];

            if (!union(curr, neighbour, parents)) {
                return edge;
            }
        }

        return new int[]{};
    }

    private boolean union(int curr, int neighbour, int[] parents) {
        int parent1 = find(curr, parents);
        int parent2 = find(neighbour, parents);

        if (parent1 == parent2) {
            return false;
        }

        // union
        // 这里只有两个根节点的事情，因为两个根节点进行 union
        parents[parent2] = parent1;

        return true;
    }

    private int find(int node, int[] parents) {
        if (parents[node] == node) {
            return node;
        }

        // path compression
        parents[node] = find(parents[node], parents);
        return parents[node];
    }
}
