import java.util.ArrayList;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: ngupta
 * Date: 27/10/19
 * Time: 12:00 PM
 */

/**
 * To get a Collatz sequence from a number, if it's even, divide it by two, and if it's odd, multiply it by three and add one. 
 * Continue the operation on the result of the previous operation until the number becomes 1. 
 */
 
public class LargestPowerOfTwoInCollatzSequence {
    public static void main(String[] args) {
        int num = 7;

        ArrayList<Integer> sequence = collatzSequence(num);
        
        System.out.println(sequence);

        System.out.println(maxPowerOfTwo(sequence));

        System.out.println(maxPowerOfTwoCleanApproach(num));
    }

    public static int maxPowerOfTwo(ArrayList<Integer> list) {
        Collections.sort(list, Collections.reverseOrder());
        for (Integer i : list) {
            if (isPowerOfTwo(i))
                return i;
        }
        return 1;
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;

        while (n != 1) {
            if (n % 2 != 0)
                return false;
            n = n / 2;
        }
        return true;
    }

    public static int maxPowerOfTwoCleanApproach(int n) {
        if (n == 4 || n == 2 || n == 1)
            return 4;
        else if (n % 2 == 0)
            if (isPowerOfTwo(n))
                return n;
        return maxPowerOfTwoCleanApproach(nextCollatz(n));
    }


    public static int nextCollatz(int n) {
        return n % 2 == 0 ? n / 2 : 3 * n + 1;
    }

    public static ArrayList<Integer> collatzSequence(int n) {

        ArrayList<Integer> arrayList = new ArrayList();
        if (n == 4) {
            //list.add(4); list.add(2); list.add(1);
            arrayList.addAll(Arrays.asList(4, 2, 1));
            return arrayList;
        }

        arrayList.add(n);
        arrayList.addAll(collatzSequence(nextCollatz(n)));
        return arrayList;
    }
}
