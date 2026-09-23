import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {


public static List<Integer> maxSubarray(List<Integer> arr) {

    // Maximum subarray sum (Kadane's algorithm)
    int currentSum = arr.get(0);
    int maxSubarray = arr.get(0);

    // Maximum subsequence sum
    int maxSubsequence = arr.get(0);
    int positiveSum = 0;
    boolean hasPositive = false;

    for (int value : arr) {

        if (value > 0) {
            positiveSum += value;
            hasPositive = true;
        }

        maxSubsequence = Math.max(maxSubsequence, value);
    }

    // If there is at least one positive number,
    // the maximum subsequence is the sum of all positive numbers.
    if (hasPositive) {
        maxSubsequence = positiveSum;
    }

    // Kadane's algorithm
    for (int i = 1; i < arr.size(); i++) {
        int value = arr.get(i);

        currentSum = Math.max(value, currentSum + value);
        maxSubarray = Math.max(maxSubarray, currentSum);
    }

    return Arrays.asList(maxSubarray, maxSubsequence);
}


}

public class Solution {


public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader =
        new BufferedReader(new InputStreamReader(System.in));

    BufferedWriter bufferedWriter =
        new BufferedWriter(
            new FileWriter(System.getenv("OUTPUT_PATH"))
        );

    int t = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, t).forEach(tItr -> {
        try {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> arr = Stream.of(
                    bufferedReader.readLine()
                        .trim()
                        .split(" ")
                )
                .map(Integer::parseInt)
                .collect(toList());

            List<Integer> result = Result.maxSubarray(arr);

            bufferedWriter.write(
                result.stream()
                    .map(Object::toString)
                    .collect(joining(" "))
                + "\n"
            );

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    });

    bufferedReader.close();
    bufferedWriter.close();
}


}
