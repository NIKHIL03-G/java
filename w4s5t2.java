import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();

        int[][] result = new int[m][n];

        // Copy original matrix into result
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = matrix.get(i).get(j);
            }
        }

        // Process each layer
        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            List<Integer> elements = new ArrayList<>();

            int top = layer;
            int left = layer;
            int bottom = m - 1 - layer;
            int right = n - 1 - layer;

            // Top row: left -> right
            for (int j = left; j <= right; j++) {
                elements.add(matrix.get(top).get(j));
            }

            // Right column: top+1 -> bottom
            for (int i = top + 1; i <= bottom; i++) {
                elements.add(matrix.get(i).get(right));
            }

            // Bottom row: right-1 -> left
            for (int j = right - 1; j >= left; j--) {
                elements.add(matrix.get(bottom).get(j));
            }

            // Left column: bottom-1 -> top+1
            for (int i = bottom - 1; i > top; i--) {
                elements.add(matrix.get(i).get(left));
            }

            int len = elements.size();
            int rotation = r % len;

            int index = 0;

            // Top row
            for (int j = left; j <= right; j++) {
                result[top][j] = elements.get((index + rotation) % len);
                index++;
            }

            // Right column
            for (int i = top + 1; i <= bottom; i++) {
                result[i][right] = elements.get((index + rotation) % len);
                index++;
            }

            // Bottom row
            for (int j = right - 1; j >= left; j--) {
                result[bottom][j] = elements.get((index + rotation) % len);
                index++;
            }

            // Left column
            for (int i = bottom - 1; i > top; i--) {
                result[i][left] = elements.get((index + rotation) % len);
                index++;
            }
        }

        // Print result
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j]);

                if (j < n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput =
            bufferedReader.readLine().trim().split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);
        int n = Integer.parseInt(firstMultipleInput[1]);
        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] row =
                bufferedReader.readLine().trim().split(" ");

            List<Integer> list = new ArrayList<>();

            for (String value : row) {
                list.add(Integer.parseInt(value));
            }

            matrix.add(list);
        }

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}