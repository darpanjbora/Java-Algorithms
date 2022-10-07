package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

/**
 * A Hamiltonian path, is a path in an undirected or directed graph that visits each vertex exactly once.
 * Given an undirected graph  the task is to check if a Hamiltonian path is present in it or not.
 *
 * Input:
 * The first line of input contains an integer T denoting the no of test cases.
 * Then T test cases follow. Each test case contains two lines. The first line consists of two space separated integers
 * N and M denoting the number of vertices and number of edges.Then in the next line are M space separated pairs u,v
 * denoting an edge from u to v.
 *
 * Output:
 * For each test case in a new line print 1 if a Hamiltonean path exists else print 0.
 *
 * Constraints:
 * 1<=T<=100
 * 1<=N<=10
 * 1<=M<=15
 *
 * Example:
 * Input:
 * 2
 * 4 4
 * 1 2 2 3 3 4 2 4
 * 4 3
 * 1 2 2 3 2 4
 * Output:
 * 1
 * 0
 */

public class HamiltonianPath {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());


        while ( t-- > 0 ){

            String line = br.readLine();

            String[] strs = line.trim().split("\\s+");

            int n = Integer.parseInt(strs[0]);
            int e = Integer.parseInt(strs[1]);

            HashMap<Integer, HashSet<Integer>> adjList = new HashMap<>();

            line =  br.readLine();
            strs = line.trim().split("\\s+");

            for (int i=0; i<strs.length; i=i+2){
                int u = Integer.parseInt(strs[i]);
                int v = Integer.parseInt(strs[i+1]);

                if(adjList.get(u) == null)
                     adjList.put(u, new HashSet<>());

                if (adjList.get(v) == null)
                    adjList.put(v,  new HashSet<>());


                adjList.get(u).add(v);
                adjList.get(v).add(u);

            }

            if(hamiltPath(n, adjList))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }

    private static boolean hamiltPath(int n, HashMap<Integer, HashSet<Integer>> adjList) {



        HashSet<Integer> nodes = new HashSet<>(adjList.keySet());

        for (Integer node : nodes){

            HashSet<Integer> visited = new HashSet<>();
            visited.add(node);
            if (hamiltPathUtil(n, adjList, visited, node))
                return true;
        }

        return false;
    }

    private static boolean hamiltPathUtil(int n, HashMap<Integer, HashSet<Integer>> adjList,
                                           HashSet<Integer> visited, Integer node) {

        if (visited.size() ==  n)
            return true;

        HashSet<Integer> childs = adjList.get(node);

        for (Integer no : childs){
            if (!visited.contains(no)){
                visited.add(no);

                boolean res = hamiltPathUtil(n, adjList, visited, no);

                if (res)
                    return true;

                visited.remove(no);

            }
        }

        return false;

    }
}
