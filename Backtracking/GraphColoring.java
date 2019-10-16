import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Given an undirected graph and an integer M.
 * The task is to determine if the graph can be colored
 * with at most M colors such that no two adjacent vertices of the graph
 * are colored with the same color.
 * Here coloring of a graph means assignment of colors to all vertices.
 * Print 1 if it is possible to colour vertices and 0 otherwise.
 *
 *
 * Vertex are 1-based (vertext number starts with 1, not 0).
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases.
 * Then T test cases follow. Each test case consists of four lines.
 * The first line of each test case contains an integer N
 * denoting the number of vertices.
 * The second line of each test case contains an integer M
 * denoting the number of colors available.
 * The third line of each test case contains an integer E denoting the number of edges
 * available. The fourth line of each test case contains E pairs
 * of space separated integers denoting the edges between vertices.
 *
 * Output:
 * Print the desired output.
 *
 * Constraints:
 * 1 <= T <= 30
 * 1 <= N <= 50
 * 1 <= E <= N*(N-1)
 * 1 <= M <= N
 *
 * Example:
 * Input :
 * 2
 * 4
 * 3
 * 5
 * 1 2 2 3 3 4 4 1 1 3
 * 3
 * 2
 * 3
 * 1 2 2 3 1 3
 *
 * Output:
 * 1
 * 0
 */

class GraphColoring
{

        public static void main (String[] args) {
            Scanner scan = new Scanner(System.in);
            int tc = scan.nextInt();

            while(tc-->0){
                int V = scan.nextInt();
                int C = scan.nextInt();
                int E = scan.nextInt();
                List<Integer>[] G = new ArrayList[V];
                for(int i = 0 ; i < V ; i++){
                    G[i] = new ArrayList<>();
                }
                for(int i = 0 ; i < E ; i++){
                    int u = scan.nextInt() - 1;
                    int v = scan.nextInt() - 1;
                    G[u].add(v);
                    G[v].add(u);
                }
                int[] color = new int[V];

                System.out.println(kColorable(G, color, 0 , C) ? 1 : 0);
            }
        }
        public static boolean kColorable(List<Integer>[] G , int[] color, int i, int C){

            if(i == G.length)
                return solved(G,color);

            for(int c = 1; c <= C; c++){
                if(legal(G, color, i, c)){
                    color[i] = c;
                    if(kColorable(G, color, i + 1, C))
                        return true;
                    color[i] = 0;
                }
            }

            return false;
        }

        public static boolean solved(List<Integer>[] G , int[] color){
            for(int i = 0 ; i < G.length ; i++){
                for(int nei : G[i]){
                    if(color[i] == 0 || color[i] == color[nei])
                        return false;
                }
            }
            return true;
        }

        public static boolean legal(List<Integer>[] G , int[] color , int i, int c){
            for(int nei : G[i]){
                if(color[nei] == c)
                    return false;
            }
            return true;
        }


}