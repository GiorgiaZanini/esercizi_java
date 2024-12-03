package it.univr.lists;

import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class IntList extends List<Integer> {

    public IntList(Integer head, IntList tail) {
        super(head, tail);
    }

    public IntList(Integer head, Integer... elements) {
        super(head, elements);
    }

    // restituisce una lista di interi letta dal file testuale indicato;
    // in caso di errore di lettura, lancia una IOException; uno Scanner vi aiuterà
    public static IntList readFrom(String fileName) throws IOException {
        Scanner scanner = new Scanner(new FileReader(fileName));
        //return readFrom(scanner);
        try {
            return new IntList(scanner.nextInt(), readFrom(scanner));
        } catch (NoSuchElementException e) {
            throw new IOException(e);
        }
    }

    private static IntList readFrom(Scanner scanner) throws IOException {
        try {
            //return new IntList(scanner.nextInt(), scanner.hasNextInt() ? readFrom(scanner) : null);

            if (scanner.hasNextInt()) {
                return new IntList(scanner.nextInt(), readFrom(scanner));
            } else {
                return null;
            }

        } catch (NoSuchElementException e) {
            throw new IOException(e);
        }

        //new IntList(1, new IntList(2, new IntList(3, null)));
    }
}
