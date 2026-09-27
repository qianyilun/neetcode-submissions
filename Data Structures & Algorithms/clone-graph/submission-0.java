/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Integer, Node> oldToNewNode = new HashMap<>();
        cloneNodeValue(node, oldToNewNode, new HashSet<>());
        connectNeighbors(node, oldToNewNode, new HashSet<>());

        return oldToNewNode.get(node.val);
    }

    private void cloneNodeValue(Node node, Map<Integer, Node> oldToNewNode, Set<Integer> visited) {
        if (node == null || visited.contains(node.val)) {
            return;
        }

        visited.add(node.val);
        Node newNode = new Node(node.val);
        oldToNewNode.put(node.val, newNode);
        for (Node neighbor : node.neighbors) {
            if (!visited.contains(neighbor.val)) {
                cloneNodeValue(neighbor, oldToNewNode, visited);
            }
        }
    }

    private void connectNeighbors(Node node, Map<Integer, Node> oldToNewNode, Set<Integer> visited) {
        if (node == null || visited.contains(node.val)) {
            return;
        }

        visited.add(node.val);
        List<Node> newNeighbors = new ArrayList<>();
        for (Node neighbor : node.neighbors) {
            if (!visited.contains(neighbor.val)) {
                connectNeighbors(neighbor, oldToNewNode, visited);
            }

            Node newNeighbor = oldToNewNode.get(neighbor.val);
            newNeighbors.add(newNeighbor);
        }

        oldToNewNode.get(node.val).neighbors = new ArrayList<>(newNeighbors);
    }
}