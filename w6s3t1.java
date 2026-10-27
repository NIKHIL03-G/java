
import java.util.Scanner;

public class Solution {

    public static int marsExploration(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char expected = "SOS".charAt(i % 3);

            if (s.charAt(i) != expected) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        System.out.println(marsExploration(s));

        sc.close();
    }
}
