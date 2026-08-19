import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                String s = sc.next();
                int n = s.length();
                int mid = n / 2;

                char[] left = s.substring(0, mid).toCharArray();
                char[] right = (n % 2 == 0 ? s.substring(mid) : s.substring(mid + 1)).toCharArray();

                Arrays.sort(left);
                Arrays.sort(right);

                System.out.println(Arrays.equals(left, right) ? "YES" : "NO");
            }
        }
        sc.close();
    }
}
