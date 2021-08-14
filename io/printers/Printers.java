package bullscows.io.printers;

import bullscows.game.GameMachine;

import java.io.BufferedWriter;
import java.io.IOException;

public class Printers {
    private static void printStars(int length, BufferedWriter writer) throws IOException {
        for (int i = 0; i < length; i++) {
            writer.write("*");
        }
        writer.flush();
    }

    public static void printCodeIsPrepared(GameMachine gameMachine, BufferedWriter writer) throws IOException {
        char[] edges = gameMachine.getEdges();
        int length = gameMachine.getLength();
        writer.write("The secret is prepared: ");
        printStars(length, writer);
        if (edges[2] == 0) {
            writer.write(String.format(" (%c-%c).%n", edges[0], edges[1]));
        } else if (edges[3] == 'a'){
            writer.write(String.format(" (%c-%c, %c).%n", edges[0], edges[1], edges[2]));
        } else {
            writer.write(String.format(" (%c-%c, %c-%c).%n", edges[0], edges[1], edges[2], edges[3]));
        }

        writer.flush();
    }

    public static void printCongrats(BufferedWriter writer) throws IOException {
        writer.write("Congratulations! You guessed the secret code.\n");
        writer.flush();
    }

    public static void printGrade(int[] bullsAndCows, BufferedWriter writer) throws IOException {
        if (bullsAndCows[0] == 0 && bullsAndCows[1] == 0) {
            writer.write("Grade: None\n");
        } else if (bullsAndCows[1] == 0) {
            writer.write(String.format("Grade: %d bull(s)%n", bullsAndCows[0]));
        } else if (bullsAndCows[0] == 0) {
            writer.write(String.format("Grade: %d cow(s)%n", bullsAndCows[1]));
        } else {
            writer.write(String.format("Grade: %d bull(s) and %d cow(s)%n", bullsAndCows[0], bullsAndCows[1]));
        }
        writer.flush();
    }

    public static void printInviteOfInputLength(BufferedWriter writer) throws IOException {
        writer.write("Input the length of the secret code:\n");
        writer.flush();
    }

    public static void printInviteOfInputRange(BufferedWriter writer) throws IOException {
        writer.write("Input the number of possible symbols in the code:\n");
        writer.flush();
    }

    public static void printStart(BufferedWriter writer) throws IOException {
        writer.write("Okay, let's start a game!\n");
        writer.flush();
    }

    public static void printTurn(int turn, BufferedWriter writer) throws IOException {
        writer.write(String.format("Turn %d:%n", turn));
        writer.flush();
    }
}
