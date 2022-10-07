package Dynamic_Programming;
/**
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5.
 */

import java.util.*;
import java.io.*;

class UglyNumbers {

    public static int getNthUglyNumber(int n) {
        int array[] = new int[n + 1];
        
        array[0] = 1;

        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        int nextMultipleOf2 = 2;
        int nextMultipleOf3 = 3;
        int nextMultipleOf5 = 5;

        
        for (int i = 1; i < n; i++) {

             int min = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));

            array[i] = min;
            if (min == nextMultipleOf2) {
                i2++;
                nextMultipleOf2 = array[i2]*2; 
            }
            if (min == nextMultipleOf3) {
                i3++;
                nextMultipleOf3 = array[i3]*3; 
            }
            if (min == nextMultipleOf5) {
                i5++;
                nextMultipleOf5 = array[i5]*5; 
            }
        }
        return array[n-1];
    }

    public static void main(String[] args) {
        int n = 150;
        System.out.println(getNthUglyNumber(n));
    }
}