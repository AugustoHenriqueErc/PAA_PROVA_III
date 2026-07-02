import java.io.PrintWriter;

public static void main(String[] args) throws Exception {

    int[] sizes = {100, 250, 500, 1000, 2000, 4000};

    PrintWriter writer = new PrintWriter("results.csv");

    writer.println(
            "n,comparisons,updates,executionTime,lisLength");

    for (int size : sizes) {

        int[] sequence = generateSequence(size);

        ExecutionResult result =
                longestIncreasingSubsequence(sequence);

        writer.println(
                size + "," +
                result.comparisons + "," +
                result.updates + "," +
                result.executionTime + "," +
                result.lisLength
        );
    }

    writer.close();

    System.out.println("results.csv generated successfully.");
}