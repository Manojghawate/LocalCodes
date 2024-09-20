package com;

import java.util.ArrayList;
import java.util.List;

public class DFS {
	private List<Integer>[]adjList;
	private boolean []visited;
	private int noOfNodes;
	public DFS(int noOfNodes) {
		visited = new boolean[noOfNodes];
		adjList = new ArrayList[noOfNodes];
		this.noOfNodes = noOfNodes;
		for(int i= 0; i< noOfNodes; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
	}
	public void print() {
		for(int i =0; i< noOfNodes; i++) {
			System.out.print(i + " -> ");
			for(int node : adjList[i]) {
				System.out.print(node + " ");
			}
			System.out.println();
		}
	}
	public void dfs(int startingNode) {
		visited[startingNode] = true;
		System.out.print(startingNode + " ");
		for(int node : adjList[startingNode]) {
			if(!visited[node])
				dfs(node);
		}
	}
	public void addEdge(int source, int dest) {
		adjList[source].add(dest);
	}

	public static void main(String[] args) {
		DFS graph = new DFS(8);

		// Add edges
		//        graph.addEdge(0, 1);
		//        graph.addEdge(0, 2);
		//        graph.addEdge(1, 2);
		//        graph.addEdge(2, 3);
		graph.addEdge(0, 1);    
		graph.addEdge(0, 2);    
		graph.addEdge(0, 3);    
		graph.addEdge(1, 3);    
		graph.addEdge(2, 4);  
		graph.addEdge(3, 5);       
		graph.addEdge(3, 6);    
		graph.addEdge(4, 7);    
		graph.addEdge(4, 5);    
		graph.addEdge(5, 2);    
		// Print the graph
		System.out.println("Graph:");
		graph.print();

		// Perform DFS
		System.out.print("DFS starting from node 0: ");
		graph.dfs(0);  // Output will vary based on graph structure and starting node

	}

}
