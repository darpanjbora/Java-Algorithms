/**
 * Time Complexity: O(V+E) where V is number of vertices in the graph and 
 *                               E is number of edges in the graph.
 * 
 * Following are the problems that use DFS as a bulding block : 
 * 1) For an unweighted graph, DFS traversal of the graph produces the minimum spanning tree and all pair shortest path tree.
 * 2) Detecting cycle in a graph 
 * 3) Path Finding
 * 4) Topological Sorting
 * 5) To test if a graph is bipartite
 * 6) Finding Strongly Connected Components of a graph.
 * 7) Solving puzzles with only one solution, such as mazes. (DFS can be adapted to find all solutions to a maze by only including nodes on the current path in the visited set.)
 */

import java.util.*;
import java.io.*;

@SuppressWarnings("unchecked")

class DFS {
    int vertices;
    LinkedList<Integer>[] adjacencyList;

    DFS(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++)
            adjacencyList[i] = new LinkedList<Integer>();
    }

    void addEdge(int v, int w) {
        adjacencyList[v].add(w);
    }

    void DFSUtil(int source, boolean[] visited){

        Stack<Integer> stack = new Stack<>();

        stack.push(source);

        while (!stack.isEmpty()) {

            int elem = stack.pop();
            
            if (!visited[elem]) {
                visited[elem] = true;
                System.out.print(elem + " ");
            }

            Iterator<Integer> iterator = adjacencyList[elem].listIterator();

            while (iterator.hasNext()) {
                int num = iterator.next();
                if (!visited[num]) {
                    stack.add(num);
                }
            }
        }
    }

    void DFSTraversal(int source) {

        System.out.print("DFS TRAVERSAL OF THE GRAPH : ");

        boolean[] visited = new boolean[vertices];

        for(int i=0 ; i<vertices; i++){
            if(!visited[i]){
                DFSUtil(i, visited);
            }
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        DFS dfs = new DFS(5);

        dfs.addEdge(1, 0);
        dfs.addEdge(0, 2);
        dfs.addEdge(2, 1);
        dfs.addEdge(0, 3);
        dfs.addEdge(1, 4);

        dfs.DFSTraversal(0);
    }
}