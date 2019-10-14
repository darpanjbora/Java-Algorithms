/**
        Given a MxN matrix where each element can either be 0 or 1.
        We need to find the shortest path between a given source cell to a destination cell.
        The path can only be created out of a cell if its value is 1.

        Expected time complexity is O(MN).

        For example –

        Input:
        mat[ROW][COL]  = {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                          {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                          {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                          {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                          {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                          {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                          {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                          {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                          {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};
        Source = {0, 0};
        Destination = {3, 4};

        Output:
        Shortest Path is 11
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given a boolean 2D matrix (0-based index), find whether there is path from (0,0) to (x,y) and if there is one path, print the minimum no of steps needed to reach it, else print -1 if the destination is not reachable. You may move in only four direction ie up, down, left and right. The path can only be created out of a cell if its value is 1.
 *
 * Input:
 * The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains two lines . The first line of each test case contains two integers n and m denoting the size of the matrix. Then in the next line are n*m space separated values of the matrix. The following line after it contains two integers x and y denoting the index of the destination.
 *
 * Output:
 * For each test case print in a new line the min no of steps needed to reach the destination.
 *
 * Constraints:
 * 1<=T<=100
 * 1<=n,m<=20
 *
 * Example:
 * Input:
 * 2
 * 3 4
 * 1 0 0 0 1 1 0 1 0 1 1 1
 * 2 3
 * 3 4
 * 1 1 1 1 0 0 0 1 0 0 0 1
 * 0 3
 * Output:
 * 5
 * 3
 */

public class MatPathDFS {

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t =  Integer.parseInt(br.readLine());

        while (t-->0){

            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            int m = Integer.parseInt(strs[0]);
            int n = Integer.parseInt(strs[1]);

            line = br.readLine();
            strs = line.trim().split("\\s+");
            int k=0;

            int mat[][] = new int[m][n];

            for (int i=0; i<m; i++){
                for (int j=0; j<n; j++){
                    mat[i][j] = Integer.parseInt(strs[k++]);
                }
            }

            int[] src = new int[]{0,0};

            strs = br.readLine().split("\\s+");
            int[] dest = new int[]{Integer.parseInt(strs[0]), Integer.parseInt(strs[1])};

            int shortest = getShorted(mat, n, m, src, dest);

            System.out.println(shortest);

        }

    }

    private static int getShorted(int[][] mat, int n, int m, int[] src, int[] dest) {

        boolean[][] visited = new boolean[m][n];


        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                visited[i][j] = mat[i][j] != 1;
            }
        }

        int shortest = visitedUtil(mat, visited, n, m, src, dest, 0, Integer.MAX_VALUE);

        if (shortest == Integer.MAX_VALUE)
            return -1;
        else
            return shortest;

    }

    private static int visitedUtil(int[][] mat, boolean[][] visited, int n, int m, int[] src, int[] dest, int dist, int shortest) {


        int sx = src[0];
        int sy = src[1];
        int dx = dest[0];
        int dy = dest[1];

        if (!isValid(sx, sy, m, n, mat, visited))
            return Integer.MAX_VALUE;

        if (dx == sx && dy == sy)
            return Math.min(shortest,dist);

        visited[sx][sy] = true;

        //left
        if (isValid(sx,sy-1, m, n, mat, visited))
           shortest =  visitedUtil(mat, visited, n, m, new int[]{sx, sy-1}, dest, dist+1, shortest);


        //up
        if (isValid(sx-1,sy, m, n, mat, visited))
            shortest =  visitedUtil(mat, visited, n, m, new int[]{sx-1, sy}, dest, dist+1, shortest);


        //down
        if (isValid(sx+1,sy, m, n, mat, visited))
            shortest =  visitedUtil(mat, visited, n, m, new int[]{sx+1, sy}, dest, dist+1, shortest);


        //right
        if (isValid(sx,sy+1, m, n, mat, visited))
            shortest =  visitedUtil(mat, visited, n, m, new int[]{sx, sy+1}, dest, dist+1, shortest);


        visited[sx][sy] = false;

        return shortest;

    }

    private static boolean isValid(int sx, int sy, int m, int n, int[][] mat, boolean[][] visited) {

        return sx >= 0 && sx < m && sy >= 0 && sy < n && mat[sx][sy] == 1 && !visited[sx][sy];

    }


}
