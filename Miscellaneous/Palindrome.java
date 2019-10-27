import java.util.Scanner;
public class main
{
    public static void main(String args[])
    {
        int flag = 0;
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        str = str.toLowerCase();
        if((str.length())%2!=0) {
            for(int i=0, j=(str.length()-1); i<(str.length())/2; i++, j--) {
                if(str.charAt(i) == str.charAt(j)) {
                    flag = 1;
                }
            }
        }
        if(flag == 1) {
            System.out.println(str + " is Palindrome.");
        } else {
            System.out.println(str + " is NOT Palindrome.");
        }
    }
}
