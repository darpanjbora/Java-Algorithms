package Dynamic_Programming;
import java.util.*;

public class LongestCommonSubSequence {
    static int countlcs(String s1, String s2) {
        int[][] count = new int[s1.length() + 1][s2.length() + 1];
        for (int i = s1.length(); i >= 0; i--) {
            for (int j = s2.length(); j >= 0; j--) {
                if (i == s1.length()) {
                    count[i][j] = 0;
                } else if (j == s2.length()) {
                    count[i][j] = 0;
                } else if (i == s1.length() && j == s2.length()) {
                    count[i][j] = 0;
                } else {
                    count[i][j] = s1.charAt(i) == s2.charAt(j) ? count[i + 1][j + 1] + 1
                            : Math.max(count[i + 1][j], count[i][j + 1]);
                }
            }
        }
        return count[0][0];
    }

    public static void main(String[] args) {
        String s1 = "abcdabr";
        String s2 = "aebdabr";
        System.out.println(countlcs(s1, s2));

    }
}