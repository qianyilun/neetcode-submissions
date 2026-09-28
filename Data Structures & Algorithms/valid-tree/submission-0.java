class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] parents = new int[n];
        
        // init
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int[] edge : edges) {
            int v = edge[0];
            int u = edge[1];

            if (!union(v, u, parents)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean union(int node, int neighbor, int[] parents) {
        int parentA = find(node, parents);
        int parentB = find(neighbor, parents);
        
        if (parentA == parentB) {
            return false;
        }
        
        // union
        parents[parentB] = parentA; 
        return true;
    }
    
    private int find(int node, int[] parent) {
        if (parent[node] == node) {
            return node;
        }
        
        // path compression
        int p = find(parent[node], parent);
        parent[node] = p;
        return p;
    }
}
