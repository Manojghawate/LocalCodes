package com;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
	private List<Integer>adjList[];
	private boolean [] visited;
	private int noOfNodes;
	
	public BFS(int noOfNodes) {
		this.adjList = new LinkedList[noOfNodes];
		this.visited = new boolean[noOfNodes];
		this.noOfNodes = noOfNodes;
		for(int i=0; i<noOfNodes; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}
	public void addEdge(int source, int dest) {
		adjList[source].add(dest);
	}
	public void print() {
		for(int i=0; i<noOfNodes; i++) {
			System.out.print(i + "->" );
			for(int node : adjList[i]) {
				System.out.print( node + " ");
			}
			System.out.println();
		}
	}
	public void bfs(int startingNode){
		Queue<Integer>queue = new LinkedList<Integer>();
		visited[startingNode] = true;
		queue.add(startingNode);
		while(!queue.isEmpty()) {
			int currentNode = queue.poll();
			System.out.print(currentNode + " ");
			for(int node : adjList[currentNode]) {
				if(!visited[node]) {
					visited[node] = true;
					queue.add(node);
				}
			}
		}
	}
	public static void main(String[] args) {
		BFS graph = new BFS(10);

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
        graph.addEdge(6, 5);    
        graph.addEdge(7, 5);  
        graph.addEdge(7, 8);   

        // Print the graph
        System.out.println("Graph:");
        graph.print();

        // Perform BFS
        System.out.print("BFS starting from node 2: ");
        graph.bfs(2);  // Output will vary based on graph structure and starting node

	}

}
