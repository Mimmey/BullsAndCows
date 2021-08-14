package bullscows;

import bullscows.math.MathOps;

public class GameMachine {
    private final int length;
    private final String secretCode;
    private final int range;
    private final char[] edges;

    public GameMachine(int length, int range) {
        this.length = length;
        this.range = range;
        secretCode = MathOps.makeRandomNumber(length, range);
        edges = MathOps.countEdgesOfRange(range);
    }

    public char[] getEdges() {
        return edges;
    }

    public int getLength(){
        return length;
    }

    public int getRange() {
        return range;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public int[] getBullsAndCows(String userAnswer) {
        if(userAnswer == null) {
            return new int[] {0, 0};
        }

        int[] bullsAndCows = {0, 0};

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (secretCode.charAt(i) == userAnswer.charAt(j)) {
                    if (i == j) {
                        bullsAndCows[0]++;
                    } else {
                        bullsAndCows[1]++;
                    }
                }
            }
        }

        return bullsAndCows;
    }
}