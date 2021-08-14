package bullscows;

import bullscows.game.GameMachine;
import bullscows.io.readers.Readers;
import bullscows.io.printers.Printers;

import java.io.*;

public class Main {
    static BufferedReader reader;
    static BufferedWriter writer;

    public static void runGame(GameMachine gameMachine) throws IOException {
        int length = gameMachine.getLength();
        String userInput = null;
        int turn = 1;

        while (gameMachine.getBullsAndCows(userInput)[0] != length) {
            Printers.printTurn(turn, writer);
            userInput = Readers.scanUserInput(reader);
            Printers.printGrade(gameMachine.getBullsAndCows(userInput), writer);
            turn++;
        }

        Printers.printCongrats(writer);
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
        GameMachine gameMachine;

        Integer length = Readers.scanLength(reader, writer);
        Integer range;

        if (length == null) {
            return;
        }

        range = Readers.scanRange(length, reader, writer);

        if (range == null) {
            return;
        }

        gameMachine = new GameMachine(length, range);

        Printers.printCodeIsPrepared(gameMachine, writer);
        Printers.printStart(writer);
        runGame(gameMachine);
        reader.close();
        writer.close();
    }
}