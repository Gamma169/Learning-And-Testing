import java.util.*;
import java.lang.*;
import java.io.*;

public class Dijkstra{
	
	// Website:   http://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/

	// 1) Create empty shortest path set
	// 2) Assign inf dist for all points
	// 3) while not all in shortest path set
	//		- pick vertex u with min distance
	//		- include u in set
	//		- update adjacent distances

	private static int V = 9;

	private int[] dijkstra(int[][] graph, int startIndex) {

		boolean[] visited = new boolean[V];
		int[] distances = new int[V];

		for (int i=0; i<V; i++)
			distances[i] = 1000000;

		distances[startIndex] = 0;

		int indexToCheck = NextLowestIndex(visited, distances);
		while (indexToCheck != -1) {

			visited[indexToCheck] = true;
			
			for (int i=0; i<V; i++) {
				if (!visited[i] && graph[i][indexToCheck] != 0 && distances[indexToCheck] + graph[i][indexToCheck] < distances[i])
					distances[i] = distances[indexToCheck] + graph[i][indexToCheck];
			}

			indexToCheck = NextLowestIndex(visited, distances);
		}


		return distances;
	}



	private int NextLowestIndex(boolean[] visitedVerts, int[] distToVert) {
		int nextIndex = -1;
		int lowestDist = 1000000;
		for (int i=0; i<V; i++) {
			if (!visitedVerts[i] && distToVert[i] < lowestDist) {
				nextIndex = i;
				lowestDist = distToVert[i];
			}
		}
		return nextIndex;
	}


	private static void printSolution(int dist[], int n) {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i+" \t\t "+dist[i]);
    }


	public static void main (String[] args) {
        /* Example graph from website */
       int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                                  {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                  {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                  {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                  {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                  {0, 0, 4, 14, 10, 0, 2, 0, 0},
                                  {0, 0, 0, 0, 0, 2, 0, 1, 6},
                                  {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                  {0, 0, 2, 0, 0, 0, 6, 7, 0}
                                 };
        Dijkstra d = new Dijkstra();
        
        int[] dists = d.dijkstra(graph, 0);

        printSolution( dists, 0);
    }


}