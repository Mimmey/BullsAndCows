package bullscows.io.readers;

import bullscows.io.printers.ErrorPrinters;
import bullscows.io.printers.Printers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Readers {
    public static Integer scanLength(BufferedReader reader, BufferedWriter writer) throws IOException {
        Printers.printInviteOfInputLength(writer);
        Integer length = null;
        String input = reader.readLine();

        try {
            length = Integer.parseInt(input);
            if (length <= 0) {
                ErrorPrinters.printNotAValidNumber(length, writer);
                length = null;
            }
        } catch (Exception e) {
            ErrorPrinters.printNotAValidNumber(input, writer);
        }

        return length;
    }

    public static Integer scanRange(int length, BufferedReader reader, BufferedWriter writer) throws IOException {
        Printers.printInviteOfInputRange(writer);
        int range;
        String input = reader.readLine();

        try {
            range = Integer.parseInt(input);
            if (range <= 0) {
                ErrorPrinters.printNotAValidNumber(range, writer);
                return null;
            }
        } catch (Exception e) {
            ErrorPrinters.printNotAValidNumber(input, writer);
            return null;
        }

        if (length > range) {
            ErrorPrinters.printNotEnoughUniqueSymbols(length, range, writer);
            return null;
        }

        if (range > 36) {
            ErrorPrinters.printLargerThanMaximum(writer);
            return null;
        } else {
            range = Integer.parseInt(input);
        }

        return range;
    }

    public static String scanUserInput(BufferedReader reader) throws IOException {
        return reader.readLine();
    }
}