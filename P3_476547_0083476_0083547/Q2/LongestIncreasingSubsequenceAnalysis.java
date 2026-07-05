import java.io.PrintWriter;
import java.util.Random;

public class LongestIncreasingSubsequenceAnalysis {

    private static final long SEED = 476547;

    static class AnalysisResult {
        long comparisons;
        long updates;
        long executionTime;
        int lisLength;
    }

    public static int[] generateSequence(int size) {
        Random random = new Random(SEED);

        int[] sequence = new int[size];

        for (int i = 0; i < size; i++) {
            sequence[i] = random.nextInt(10000);
        }

        return sequence;
    }

    public static AnalysisResult longestIncreasingSubsequence(int[] sequence) {

        int size = sequence.length;

        int[] best = new int[size];
        int[] next = new int[size];

        long comparisons = 0;
        long updates = 0;

        long startTime = System.nanoTime();

        for (int i = 0; i < size; i++) {
            best[i] = 1;
            next[i] = -1;
        }

        for (int i = size - 2; i >= 0; i--) {
            for (int j = i + 1; j < size; j++) {

                comparisons++;

                if (sequence[j] > sequence[i]
                        && best[j] + 1 > best[i]) {

                    best[i] = best[j] + 1;
                    next[i] = j;
                    updates++;
                }
            }
        }

        int largestSubsequence = best[0];

        for (int i = 1; i < size; i++) {
            if (best[i] > largestSubsequence) {
                largestSubsequence = best[i];
            }
        }

        long endTime = System.nanoTime();

        AnalysisResult result = new AnalysisResult();
        result.comparisons = comparisons;
        result.updates = updates;
        result.executionTime = endTime - startTime;
        result.lisLength = largestSubsequence;

        return result;
    }

    public static void main(String[] args) throws Exception {

        int[] sizes = {100, 250, 500, 1000, 2000, 4000};

        PrintWriter writer = new PrintWriter("results.csv");

        writer.println(
                "n,comparisons,updates,time,lisLength");

        for (int size : sizes) {

            int[] sequence = generateSequence(size);

            AnalysisResult result =
                    longestIncreasingSubsequence(sequence);

            writer.println(
                    size + "," +
                    result.comparisons + "," +
                    result.updates + "," +
                    result.executionTime + "," +
                    result.lisLength
            );

            System.out.println(
                    "n = " + size +
                    " | comparisons = " + result.comparisons +
                    " | updates = " + result.updates +
                    " | time = " + result.executionTime +
                    " ns | LIS = " + result.lisLength
            );
        }

        writer.close();

        System.out.println("results.csv generated successfully.");
    }
}