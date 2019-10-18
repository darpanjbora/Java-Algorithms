package Sorting_Algorithms;

import java.io.*;
class Bubble
{
    public static void main()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int i,j,t,n;
        System.out.println("Enter the size of the array");
        n=Integer.parseInt(br.readLine());
        int a[]=new int[n];
        System.out.println("Enter the array elements");
        for(i=0;i<n;i++)
            a[i]=Integer.parseInt(br.readLine());
        System.out.println("ORIGINAL ARRAY");
        for(i=0;i<n;i++)
           System.out.print(a[i]+"  ");
        System.out.println();
        for(i=0;i<n;i++)
           for(j=0;j<n-1;j++)
                if(a[j]>a[j+1])
                {
                    t=a[j];
                    a[j]=a[j+1];
                    a[j+1]=t;
                }
        System.out.println("SORTED ARRAY");
        for(i=0;i<n;i++)
            System.out.print(a[i]+"  ");
        }
    }