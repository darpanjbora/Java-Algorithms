
/**
 * A disjoint-set data structure is a data structure that 
 * keeps track of a set of elements partitioned into a number of disjoint (non-overlapping) subsets. 
 * A union-find algorithm is an algorithm that performs two useful operations on such a data structure:
 * Find: Determine which subset a particular element is in. 
 * This can be used for determining if two elements are in the same subset.
 * Union: Join two subsets into a single subset.
 * 
 * the implementation of union() and find() is naive and takes O(n) time in worst case. 
 * These methods can be improved to O(Logn) using Union by Rank or Height.
 */

import java.util.*;
import java.io.*;

class DetectCycleDisjointSet {

    int V, E;
    Edge edge[];

    class Edge {
        int src, dest;
    };

    DetectCycleDisjointSet(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    static int find(int parent[], int index) {

        if (parent[index] == -1)
            return index;
        return find(parent, parent[index]);
    }

    static void Union(int parent[], int x, int y) {
        int xSet = find(parent, x);
        int ySet = find(parent, y);
        parent[xSet] = ySet;
    }

    static boolean isCycle(DetectCycleDisjointSet graph) {

        int parent[] = new int[graph.V];

        Arrays.fill(parent, -1);

        for (int i = 0; i < graph.E; i++) {

            int srcSet = find(parent, graph.edge[i].src);
            int destSet = find(parent, graph.edge[i].dest);

            if (srcSet == destSet)
                return true;

            Union(parent, srcSet, destSet);
        }

        return false;
    }

    public static void main(String[] args) {

        int V = 5, E = 5;

        DetectCycleDisjointSet graph = new DetectCycleDisjointSet(V, E);


        /**
         *             0
         *            / \
         *           1   2
         *          / \
         *         3 - 4
         */

        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;

        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;

        graph.edge[2].src = 1;
        graph.edge[2].dest = 3;

        graph.edge[3].src = 1;
        graph.edge[3].dest = 4;

        graph.edge[4].src = 3;
        graph.edge[4].dest = 4;

        System.out.println("Graph contains cycle: " + isCycle(graph));
    }
}