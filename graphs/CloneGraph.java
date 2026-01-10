package graphs;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }
}

public class CloneGraph {
    private final Map<Node, Node> visited = new HashMap<>();

    private Node cloneGraph(Node node) {
        // Explanation:
        // We use DFS with a HashMap to keep track of cloned nodes.
        // For each node, we recursively clone its neighbors.
        if (node == null) return null;
        if (visited.containsKey(node)) return visited.get(node);

        Node clone = new Node(node.val);
        visited.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }
        return clone;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        CloneGraph cg = new CloneGraph();
        Node clone = cg.cloneGraph(n1);
        System.out.println("Cloned node value: " + clone.val); // Expected: 1
    }
}

