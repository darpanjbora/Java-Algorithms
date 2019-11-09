package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 * Input:
 * 2
 * 1
 * 4
 * Output:
 * [1 ]
 * [2 4 1 3 ] [3 1 4 2 ]
 */


public class NQueen {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // test cases
        int t =  Integer.parseInt(br.readLine());

        while (t-- > 0){

            // matrix dimension

            int N = Integer.parseInt(br.readLine());

            solveNQ(N);


            System.out.println();

        }

    }

    private static void printResult(ArrayList<int[]> result, int N) {

        StringBuilder sb = new StringBuilder();

        for ( int[] arr : result){
            sb.append("[");
            for( int i=1; i<N; i++){
                sb.append(arr[i]+" ");
            }
            sb.append("] ");
        }

        System.out.print(sb);
    }

    private static void solveNQ(int N) {

        ArrayList<int[]> result = new ArrayList<>();

        int[] a = new  int[N+1];

        solveNQUtil(result, N+1, a, 1);

        if (result.size()>0)
        {
            printResult(result, N+1);
        }
        else
        {
            System.out.print(-1);
        }

    }

    private static void solveNQUtil(ArrayList<int[]> result, int N,int[] a, int row) {

        if ( row == N ){
            int arr[] = new int[N];

            for (int i = 1; i< N; i++){
                arr[i] = a[i];
            }
            result.add(arr);

            return;
        }


        for(int i = 1; i< N; i++){

                a[row] = i;
            if (isSafe(a, N, row, i)){
               solveNQUtil(result, N, a , row+1);
            }
        }


    }

    private static boolean isSafe(int[] a, int n, int row, int col) {

         if( row == 1)
              return true;

         for ( int i = row-1; i>0 ; i--){
             if ( a[i] == col || a[i]+i == row+col ||  i - a[i] == row - col)
                 return false;
         }

         return true;
    }


}
