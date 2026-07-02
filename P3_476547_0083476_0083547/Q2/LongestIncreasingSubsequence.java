public static ExecutionResult longestIncreasingSubsequence(int[] sequence) {

    int n = sequence.length;

    int[] best = new int[n];
    int[] next = new int[n];

    long comparisons = 0;
    long updates = 0;

    long startTime = System.nanoTime();

    for (int i = 0; i < n; i++) {
        best[i] = 1;
        next[i] = -1;
    }

    for (int i = n - 2; i >= 0; i--) {
        for (int j = i + 1; j < n; j++) {

            comparisons++;

            if (sequence[j] > sequence[i]
                    && best[j] + 1 > best[i]) {

                best[i] = best[j] + 1;
                next[i] = j;
                updates++;
            }
        }
    }

    int maxLength = best[0];

    for (int i = 1; i < n; i++) {
        if (best[i] > maxLength) {
            maxLength = best[i];
        }
    }

    long endTime = System.nanoTime();

    ExecutionResult result = new ExecutionResult();
    result.comparisons = comparisons;
    result.updates = updates;
    result.executionTime = endTime - startTime;
    result.lisLength = maxLength;

    return result;
}