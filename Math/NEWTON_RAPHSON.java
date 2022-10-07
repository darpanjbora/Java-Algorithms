import java.util.Scanner;


//This method is used to find the square root of a number
// Formula of this method is: root= (x+n/x)2; x= guessed number, n= number to find its sqrt root


public class NEWTON_RAPHSON {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number to find its square root");
        int num= sc.nextInt();
        double root;
        double x=num;
        while (true){
            root= (x+num/x)/2;
            if(Math.abs(x-root)<1)
                break;
             x=root;
        }
        System.out.println(root);
    }
}
