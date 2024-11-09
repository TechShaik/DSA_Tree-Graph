package com.BFS_DFS;
import java.util.*;

public class  DFS {
    private Map<Integer, List<Integer>> adjList;

    // Constructor
    public DFS() {
        adjList = new HashMap<>();
    }

    // Add an edge to the graph
    public void addEdge(int source, int destination) {
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.get(source).add(destination);
    }

    // Recursive DFS helper
    public void dfsRecursive(int node, Set<Integer> visited) {
        if (visited.contains(node)) return;

        visited.add(node);
        System.out.print(node + " ");

        for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    public void dfs(int startNode) {
        Set<Integer> visited = new HashSet<>();
        dfsRecursive(startNode, visited);
    }

    public static void main(String[] args) {
         DFS graph = new  DFS();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        System.out.println("DFS traversal starting from node 0:");
        graph.dfs(0);
    }
}
