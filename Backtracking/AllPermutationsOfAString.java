/**
 * A string of length n has n! permutation.
 */

import java.util.*;
import java.io.*;

class AllPermutationsOfAString {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        int len = S.length();
        AllPermutationsOfAString per = new AllPermutationsOfAString();
        per.permute(S, 0, len-1);

    }

    public void permute(String S, int l, int r){
        if (l == r)
            System.out.println(S);
        else{
            for(int i=l; i<=r; i++){
                S = swap(S, l, i);
                permute(S, l+1, r);
                S = swap(S, l, i);
            }
        }
    }

    //Swapping characters of a string.
    public String swap(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    } 
}