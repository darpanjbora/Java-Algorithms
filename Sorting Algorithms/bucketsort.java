

    // Bucket Sort in Java programming
    import java.util.*;
    class BucketSort {
      public static void bucketSort(int[] array, int size) {
        int max = (Arrays.stream(array).max().getAsInt());
        int[] bucket = new int[max + 1];
        for (int i = 0; i <= max; i++) {
          bucket[i] = 0;
        }
        for (int i = 0; i < size; i++) {
          bucket[array[i]]++;
        }
        for (int i = 0, j = 0; i <= max; i++) {
          while (bucket[i] > 0) {
            array[j++] = i;
            bucket[i]--;
          }
        }
      }
      public static void main(String[] args) {
        int[] data = { 4, 3, 4, 5, 6, 9, 1, 5 };
        int size = data.length;
        BucketSort bs = new BucketSort();
        bs.bucketSort(data, size);
        System.out.println("Sorted Array in Ascending Order: " + Arrays.toString(data));
      }
    }

