package graphs;

import java.util.*;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        // Explanation:
        // A valid tree must have exactly n-1 edges and be fully connected.
        // We use Union-Find to detect cycles and ensure connectivity.
        if (edges.length != n - 1) return false;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int[] edge : edges) {
            int root1 = find(parent, edge[0]);
            int root2 = find(parent, edge[1]);
            if (root1 == root2) return false;
            parent[root1] = root2;
        }
        return true;
    }

    private int find(int[] parent, int i) {
        if (parent[i] != i) parent[i] = find(parent, parent[i]);
        return parent[i];
    }

    public static void main(String[] args) {
        GraphValidTree gvt = new GraphValidTree();
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
        System.out.println("Is valid tree: " + gvt.validTree(5, edges)); // Expected: true
    }
}

