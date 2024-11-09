package com.BFS_DFS;
import java.util.*;

public class BFS {
    private Map<Integer, List<Integer>> adjList;

    // Constructor
    public BFS() {
        adjList = new HashMap<>();
    }

    // Add an edge to the graph
    public void addEdge(int source, int destination) {
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.get(source).add(destination);
    }

    // BFS traversal from a given start node
    public void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.print(currentNode + " ");

            // Visit all unvisited neighbors
            for (int neighbor : adjList.getOrDefault(currentNode, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
    	BFS graph = new BFS();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        System.out.println("BFS traversal starting from node 0:");
        graph.bfs(0);
    }
}

