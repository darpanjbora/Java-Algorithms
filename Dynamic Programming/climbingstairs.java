import java.io.*;
public class stairs
{
  int leg1;
  int store = new int[100000]//can increase or decrease depending on the constraints on n
  int calc(int n)
  {
    if(store[n] != -1)
    return store[n];
    if(n==1)
    store[n] = 1;
    else if(n<1)
    store[n]=0;
    else
    store[n] = calc(n-1) + calc(n-leg1);
    return store[n];
  }
  
  public void main(String args[])throws IOException
  {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Please enter number of test cases");
    nt t = Integer.parseInt(in.readLine());
    for(int i=0;i<100000;i++)
    store[i] = -1;
    System.out.println("please enter the size of leg");//number of steps person can cover in one turn. If size=1, 1 step at a time
    leg1 = Integer.parseInt(in.readLine());//other leg is assumed to be 1
    while(t!=0)
    {
    t--;
    System.out.println("please enter the total number of stairs");
    int n = Integer.parseInt(in.readLine());
    ans = calc(n);
    System.out.println("the answer is "+ans);
    }
  }
}  
