import java.io.*;
public class expon()
{
  int calc(int base,int power)
  {
    int ans=1;
    while(powr!=0)
    {
      int setbit = power&1;
      if(setbit==1)
      ans = ans*base;
      base = base*base;
      power = power/2;
    }
    return ans;
  }
  
  public void main(String args[])throws IOException
  {
    int base;
    int power;
    System.out.println("please enter the base and the power");
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    base = Integer.parseInt(in.readLine());
    power = Integer.parseInt(in.readLine());
    int ans = calc(base,power);
    System.out.println("the answer is "+ans);
  }
}  
   
    
