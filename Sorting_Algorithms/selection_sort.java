package Sorting_Algorithms;

import java.io.*;
class Selection
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
           for(j=i+1;j<n;j++)
                if(a[i]>a[j])
                {
                    t=a[i];
                    a[i]=a[j];
                    a[j]=t;
                }
        System.out.println("SORTED ARRAY");
        for(i=0;i<n;i++)
            System.out.print(a[i]+"  ");
        }
    }