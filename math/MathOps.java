package bullscows.math;

import java.util.Random;

public final class MathOps {
    public static char[] countEdgesOfRange(int range) {
        char[] edges = {0, 0, 0, 0};
        edges[0] = '0';
        if (range < 11) {
            edges[1] = (char)('0' + range - 1);
        } else {
            edges[1] = '9';
            edges[2] = 'a';
            edges[3] = (char)('a' + range - 11);
        }

        return edges;
    }

    public static String makeRandomNumber(int length, int range) {
        Random random = new Random(Math.round(Math.random() * 10000));
        char[] randomNumber = new char[length];
        boolean[] digitIsUsed = new boolean[range];

        for (int i = 0; i < length; i++) {
            int digit = random.nextInt(range);
            while(i == 0 && digit == 0 || digitIsUsed[digit]) {
                digit = random.nextInt(range);
            }

            if (digit < 10) {
                randomNumber[i] = (char) (digit + '0');
            } else {
                randomNumber[i] = (char) (digit + 'a' - 10);
            }

            digitIsUsed[digit] = true;
        }

        return String.valueOf(randomNumber);
    }
}
