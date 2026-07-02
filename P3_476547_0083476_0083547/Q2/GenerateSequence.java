import java.util.Random;

public static int[] generateSequence(int size) {
    final long SEED = 476547L;

    Random random = new Random(SEED);
    int[] sequence = new int[size];

    for (int i = 0; i < size; i++) {
        sequence[i] = random.nextInt(10000);
    }

    return sequence;
}   