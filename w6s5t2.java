
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static int longestPalindrome(String s) {
        int maxLength = 1;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, expand(s, i, i));
            maxLength = Math.max(maxLength, expand(s, i, i + 1));
        }

        return maxLength;
    }

    private static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        int n = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();

        for (int i = 0; i < n; i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            System.out.println(longestPalindrome(rotated));
        }

        br.close();
    }
}
