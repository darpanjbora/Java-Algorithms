import java.util.Scanner;
public class Main
{
    public static void main(Strings[] args)
    {
        int w[][]=new int[10][10];
        int n, i, j, s, k=0;
        int min;
        int sum=0;
        int u=0, v=0;
        int flag=0;
        int sol[]=new int[10];
        System.out.println("Enter the no. of vertices: ");
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for(i=1; i<=n; i++)
            sol[i]=0;
        System.out.println("Enter the weighted graph:");
        for(i=1; i<=n; i++)
            for(j=1; j<=n; j++)
                w[i][j]=sc.nextInt();
        System.out.println("Enter the source vertex:");
        s=sc.nextInt();
        sol[s]=1;
        k=1;
        while(k<=n-1)
        {
            min=999;
            for(i=1; i<=n; i++)
                for(j=1; j<=n; j++)
                    if(sol[i]==1&&sol[j]==0)
                        if(i!=j&&min>w[i][j])
                        {
                            min=w[i][j];
                            u=i;
                            v=j;
                        }
                        sol[v]=1;
                        sum=sum+min;
                        k++;
                        System.out.println(u+"->"+v+"="+min);
        }
        for(i=1; i<=n; i++)
            if(sol[i]==0)
                flag=1;
        if(flag==1)
            System.out.println("No spanning tree possible.");
        else
            System.out.println("Cost of the minimum spanning tree is: "+sum);
    }
}