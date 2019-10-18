package Operating_Systems;
/*
 PROGRAM : BANKER'S ALGORITHM
 Author  : Yukta peswani
 Website : www.yuktapeswani.tk

 */

import java.io.*;
import java.util.*;

class Bankers {
    static int safe[] = new int[20];
    static int unsafe[] = new int[20];

    static boolean safety(int available[], int allocated[][], int need[][], int n1, int m1) {
        int n = n1;
        int m = m1;
        int nd[][] = new int[n][m];
        int work[] = new int[m];
        int alloc[][] = new int[n][m];

        /* Populate the work array with the passed available array */
        for (int i = 0; i < m; i++) {
            work[i] = available[i];
        }

        /** Print Available array */
        System.out.println("*** Available Array /n");
        for( int i = 0; i < work.length; i++ ) {
            System.out.println( work[i] + " " );
        }

        /* Populate the alloc array with the passed allocated array */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                alloc[i][j] = allocated[i][j];
            }
        }

        /** Print Allocated array */
        System.out.println("*** Allocated Array /n");
        for( int i = 0; i < alloc.length; i++ ) {
            for( int j = 0; j < alloc[i].length; j++ ) {
                System.out.print( alloc[i][j] + " " );
            }
            System.out.println();
        }

        /* Populate the nd array with the passed need array */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nd[i][j] = need[i][j];
            }
        }

        /** Print Need Array */
        System.out.println("*** Need Array \n");
        for( int i = 0; i < nd.length; i++ ) {
            for( int j = 0; j < nd[i].length; j++ ) {
                System.out.print( nd[i][j] + " " );
            }
            System.out.println();
        }

        /* Hold the finished processes */
        boolean finish[] = new boolean[n];

        /* Initialize the finished array to false */
        for (int i = 0; i < n; i++) {
            finish[i] = false;
        }

        /* Two counters for the two-dimensional array */
        int check = 0;
        int check1 = 0;

        /**
         * Chek for safey algorithm.
         *
         * 1. Work = available.
         *    Finish = false.
         *
         * 2. Find an i such that,
         *    Finish[i] = false and Needi < Work.
         *    If no such Item, go step 4
         *
         * 3. Work = Work + Allocationi
         *    Finish[i] = true, then repeat step 2
         *
         * 4. If Finish[i] = true for all i , then
         *    the system is in safe.
         */
        do {
            for (int i = 0; i < n; i++) {
                boolean flag = true; /* Temp Flag */
                if ( finish[i] == false ) {
                    for (int j = 0; j < m; j++) {
                        if (work[j] < nd[i][j]) {
                            flag = false;
                        }
                    }

                    /* If available resources are greater than needed, then assign allocated resources
                     for processing */
                    if ( flag ) {
                        for (int j = 0; j < m; j++) {
                            work[j] += alloc[i][j];
                        }
                        safe[check] = i; /* Put the process number (Pi) in the safe array */
                        check++;
                        finish[i] = true;
                    } else {
                        unsafe[check] = i; /* Put the process number (Pi) in the safe array */
                    }
                }
            }

            check1++; /* Navigate to the next process */
        } while ( check < n && check1 < n);

        if (check > n) {
            return false;
        } else {
            return true;
        }
    } // END-safety() function

    

    /** Main Function */
    public static void main(String args[]) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader obj = new BufferedReader(isr);

        int n, m; /* n = Number of Processes, m = Number of resources. */
        System.out.println("enter no. of processes: "); /* Enter number of processes. */
        n = Integer.parseInt(obj.readLine());
        System.out.println("enter no. of resources: "); /* Enter number of Resources. */
        m = Integer.parseInt(obj.readLine());

        int availableArr[] = new int[m]; // Array of available instances
        for (int i = 0; i < m; i++) {
            System.out.println("enter no. of available instances resources: " + i);
            /* Enter number of Available instances. */
            availableArr[i] = Integer.parseInt(obj.readLine());
        }

        System.out.println("enter allocation of resources: ");
        /* Allocation Array. */
        int allocArr[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                /* Enter allocation of instances of resources. */
                System.out.println("enter allocation instances of resources: " + j + " for process p" + i);
                /* Enter allocation of instances of resources. */
                allocArr[i][j] = Integer.parseInt(obj.readLine());
            }
        }

        System.out.println("enter maximum of resources: ");
        int maxArr[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println("enter max instances of resources:" + j + "for process p" + i);

                /* Enter max instances of resources for a given resource. */
                maxArr[i][j] = Integer.parseInt(obj.readLine());
            }
        }

        /** Print max Array */
        System.out.println("*** max Array \n");
        for( int i = 0; i < maxArr.length; i++ ) {
            for( int j = 0; j < maxArr[i].length; j++ ) {
                System.out.print( maxArr[i][j] + " " );
            }
            System.out.println();
        }

        /* Needed Array. */
        int needArr[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                /* Populate Need Array */
                needArr[i][j] = maxArr[i][j] - allocArr[i][j];
            }
        }

        /**
         * Now, we have the availableArr, maxArr, neededArr, and allocArr
         * Pass them to function safety() for processing
         */
        if ( safety( availableArr, allocArr, needArr, n, m )) {
            System.out.println("System in Safe State");
            System.out.print("System's Safe sequence:");
            for (int i = 0; i < n; i++) {
                System.out.print( "P" + safe[i] + " " );
            }
        } else {
            System.out.println("System in UnSafe State");
            System.out.print("System's Safe sequence:");
            for (int i = 0; i < n; i++) {
                System.out.print( "P" + unsafe[i] + " " );
            }
        }

    }
}