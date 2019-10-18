/**
 * Time Complexity: O(V+E) where V is number of vertices in the graph and 
 *                               E is number of edges in the graph.
 */


import java.util.*;
import java.io.*;

@SuppressWarnings("unchecked")

class BFS {
    int vertices;
    LinkedList<Integer>[] adjacencyList ;

    BFS(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for(int i=0; i<vertices; i++)
            adjacencyList[i] = new LinkedList();
    }

    void addEdge(int v, int w){
        adjacencyList[v].add(w);
    }

    void BFSTraversal(int source){
        
        boolean[] visited = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[source] = true;
        queue.add(source);
        System.out.print("BFS TRAVERSAL OF THE GRAPH : ");

        while(!queue.isEmpty()){

            int elem = queue.poll();
            System.out.print(elem+" ");

            Iterator<Integer> iterator = adjacencyList[elem].listIterator();

            while(iterator.hasNext())
            {
                int num = iterator.next();
                if(!visited[num]){
                    visited[num] = true;
                    queue.add(num);
                }
            }
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        BFS bfs = new BFS(7);

        bfs.addEdge(1, 2);
        bfs.addEdge(1, 3);
        bfs.addEdge(2, 4);
        bfs.addEdge(2, 5);
        bfs.addEdge(3, 5);
        bfs.addEdge(4, 5);
        bfs.addEdge(4, 6);
        bfs.addEdge(5, 6);

        bfs.BFSTraversal(1);
    }
}