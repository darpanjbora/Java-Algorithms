import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Number Checker!");
        perfect();
    }
    public static void perfect(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n =input.nextInt();
        int sum=0;
        for(int i =1;i<n;i++){
            if (n%i==0){
                sum=sum+i;
            }
        }
        if (sum==n){
            System.out.print("This number is perfect.");
        }
        else{
            System.out.print("This number is not perfect.");
        }
    }
}
