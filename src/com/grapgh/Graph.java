package com.grapgh;
import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> adjList; // Adjacency list representation

     public Graph() {
        adjList = new HashMap<>();
    }

     public void addVertex(int vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

     public void addEdge(int source, int destination) {
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.putIfAbsent(destination, new ArrayList<>());

        adjList.get(source).add(destination);
        adjList.get(destination).add(source);  
    }

     public void displayGraph() {
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            System.out.print("Vertex " + entry.getKey() + " is connected to: ");
            for (int neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

     

    public static void main(String[] args) {
        Graph graph = new Graph();
        
         for (int i = 0; i < 7; i++) {
            graph.addVertex(i);
        }

         graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

         System.out.println("Graph representation:");
        graph.displayGraph();

          
    }
}
