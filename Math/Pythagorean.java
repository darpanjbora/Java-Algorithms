// Java program to generate pythagorean  triplets smaller than a given limit

import java.util.*;

public class Pythagorean {

	// Function to generate pythagorean  triplets smaller than limit
	static void pythagoreanTriplets(int limit)
	{

		// triplet: a^2 + b^2 = c^2
		int a, b, c = 0;

		// loop from 2 to max_limit
		int m = 2;

		// Limiting c would limit
		// all a, b and c
		while (c < limit) {

			// now loop on j from 1 to i-1
			for (int n = 1; n < m; ++n) {
				// Evaluate and print
				// triplets using
				// the relation between
				// a, b and c
				a = m * m - n * n;
				b = 2 * m * n;
				c = m * m + n * n;

				if (c > limit)
					break;

				System.out.println(a + " " + b + " " + c);
			}
			m++;
		}
	}
	public static void main(String []args)
	{
		int limit = 20;
		pythagoreanTriplets(limit);
	}
}
//Time complexity of this approach is O(n) where n is number of triplets printed 
// for a given limit (We iterate for m and n only and every iteration prints a triplet)