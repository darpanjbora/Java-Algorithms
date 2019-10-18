import java.util.Arrays;
import java.util.Random;

/**
 * Java Implementation of the Bogo Sort (a highly inefficient sorting algorithm based on the generate and test paradigm.)
 * See: https://en.wikipedia.org/wiki/Bogosort
 */
class BogoSort {

    public static void bogoSort(int arr[]) {
        int counter = 0;
        while (!test(arr)) {
            shuffle(arr);
            counter++;
        }
        System.out.println("SUCCESS! (After " + counter + " shuffles");
        System.out.println(Arrays.toString(arr));
    }

    private static void shuffle(int arr[]) {
        final Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            final int value = arr[i];
            final int indexToSwapWith = random.nextInt(arr.length);
            final int valueToSwapWith = arr[indexToSwapWith];
            arr[i] = valueToSwapWith;
            arr[indexToSwapWith] = value;
        }
    }

    private static boolean test(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int value = arr[i];
            int nextValue = arr[i + 1];
            if (value > nextValue) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] testArray = new int[] {1, 4, 5, 2, 27, 19, 18};
        bogoSort(testArray);
    }
}
