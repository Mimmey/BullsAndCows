package bullscows.io.printers;

import java.io.BufferedWriter;
import java.io.IOException;

public class ErrorPrinters {

    public static void printNotEnoughUniqueSymbols(int length, int range, BufferedWriter writer) throws IOException {
        writer.write("Error: it's not possible to generate a code with a length of " +  length + " with " + range + " unique symbols.\n");
        writer.flush();
    }

    public static void printNotAValidNumber(String input, BufferedWriter writer) throws IOException {
        writer.write("Error: \"" + input + "\" isn't a valid number.\n");
        writer.flush();
    }

    public static void printNotAValidNumber(int n, BufferedWriter writer) throws IOException {
        writer.write("Error: " + n + " isn't a valid number.\n");
        writer.flush();
    }

    public static void printLargerThanMaximum(BufferedWriter writer) throws IOException {
        writer.write("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).\n");
        writer.flush();
    }

}
