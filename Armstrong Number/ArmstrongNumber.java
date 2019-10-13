/**
 * Created with IntelliJ IDEA.
 * User: ngupta
 * Date: 14/10/19
 * Time: 1:12 AM
 */

 /**
    Armstrong number is a number that is equal to the sum of cubes of its digits. 
    For example 0, 1, 153, 370, 371 and 407 are the Armstrong numbers.

 */
public class ArmstrongNumber {
    public static void main(String[] args) {
        int start = 0;
        int end = 1000000;

        //print all the armstrong numnbers from 0 to 1000000
        printArmstrongNumbers(start, end);
    }

    public static void printArmstrongNumbers(int start, int end) {
        for (int i = start; i < end; i++) {
            if (isArmstrong(i))
                System.out.println(i);
        }
    }

    public static boolean isArmstrong(int n) {

        if (n < 10)
            return true;

        int length = numberLength(n);

        int num = 0;
        int nCopy = n;
        int digit;

        while (n > 0) {
            digit = n % 10;
            num += Math.pow(digit, length);
            n /= 10;
        }

        return nCopy == num;
    }

    public static int numberLength(int n) {
        int len = 0;
        while (n > 0) {
            len++;
            n /= 10;
        }
        return len;
    }
}
