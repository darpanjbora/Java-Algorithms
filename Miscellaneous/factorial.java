import java.math.BigInteger;

public class factorial{
	public static BigInteger rec(int q){
		BigInteger u=BigInteger.valueOf(q);
		if(q==1)
		{
			return u;
		}
		else 
			return (u.multiply(rec(q-1)));
	}
	public static void main(String[] args){
		int a=100;
		System.out.println(rec(a));
	}
}
