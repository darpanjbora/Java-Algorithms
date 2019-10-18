/**
 * A Bipartite Graph is a graph whose vertices can be divided into two independent sets, U and V
 *  such that every edge (u, v) either connects a vertex from U to V or a vertex from V to U. 
 * In other words, for every edge (u, v), either u belongs to U and v to V, 
 * or u belongs to V and v to U. 
 * We can also say that there is no edge that connects vertices of same set.
 * 
 * 
 * Time Complexity of the above approach is same as that Breadth First Search.
 * O(V^2) where V is number of vertices. 
 * If graph is represented using adjacency list, 
 * then the complexity becomes O(V+E).
 */


import java.util.*;
import java.io.*;

class Bipartite {

    public static boolean isBipartiteUtil(int G[][], int index, int colorArray[], int V) {

        colorArray[index] = 1;

        LinkedList<Integer> queue = new LinkedList<Integer>();

        queue.add(index);

        while (!queue.isEmpty()) {

            int elem = queue.pop();

            if (G[elem][elem] == 1) {
                return false;
            }

            for (int i = 0; i < V; i++) {

                if (G[elem][i] == 1 && colorArray[i] == -1) {

                    colorArray[i] = 1 - colorArray[elem];
                    queue.push(i);
                }

                else if(G[elem][i] == 1 && colorArray[i] == colorArray[elem]){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isBipartite(int V, int G[][]) {

        int[] colorArray = new int[V];
        Arrays.fill(colorArray, -1);

        for (int i = 0; i < V; i++) {
            if (colorArray[i] == -1) {
                if (isBipartiteUtil(G, i, colorArray, V) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int G[][] = { { 0, 1, 0, 1 }, { 1, 0, 1, 0 }, { 0, 1, 0, 1 }, { 1, 0, 1, 0 } }; // Adjacency Matrix
        int V = 4; // Vertices

        if (isBipartite(V, G))
            System.out.println("Yes, the graph is bipartite.");
        else
            System.out.println("No, it's not!");
    }
}