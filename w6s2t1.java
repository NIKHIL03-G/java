
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static String twoStrings(String s1, String s2) {
        boolean[] seen = new boolean[26];

        for (int i = 0; i < s1.length(); i++) {
            seen[s1.charAt(i) - 'a'] = true;
        }

        for (int i = 0; i < s2.length(); i++) {
            if (seen[s2.charAt(i) - 'a']) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        int t = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < t; i++) {
            String s1 = br.readLine().trim();
            String s2 = br.readLine().trim();

            System.out.println(twoStrings(s1, s2));
        }

        br.close();
    }
}
