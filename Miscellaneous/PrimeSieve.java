import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class PrimeSieve {

    /*
    For a given N, it will print all primes less than or equal to N
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Enter the N");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Boolean[] visited = new Boolean[N + 1];
        Arrays.fill(visited, Boolean.FALSE);

        ArrayList<Integer> primes = new ArrayList<>();

        primes.add(2);

        for (int i = 3; i * i <= N; i += 2) {
            if (!visited[i]) {
                for (int j = i * i; j <= N; j += 2 * i) {
                    visited[j] = true;
                }
            }
        }

        for (int i = 3; i <= N; i += 2) {
            if (!visited[i])
                primes.add(i);
        }

        System.out.println("Primes <= N are:");

        primes.forEach(System.out::println);

        br.close();
    }

}
