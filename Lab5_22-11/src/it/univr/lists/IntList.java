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
        Scanner scanner = new Scanner(new FileReader(fileName));//crea un oggetto Scanner che legge da file
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
                //soluzione → ma anche questa è ricorsiva, ma ritorna, il primo parametro (head) al costruttore, prima di fare il controllo scanner.hasNextInt(),
                // (quindi ritorna un errore, perché non controlla il primo ma ritorna direttamente, e poi fa il controllo sui successivi), e fa il controllo sul secondo parametro (tail)
                //aggiungo il ritorno del primo senza controllo nel readFrom(String) *
                //soluzione → ritorna il primo parametro (head) (scanner.nextInt()),
                // poi per il secondo (tail) → if il file ha un intero successivo (scanner.hasNextInt() ?) se è true, ritorna leggi (readFrom(scanner)), sennò ( : ) ritorna null (null)

            //ricorsivo → implementata la soluzione per esteso **
            if (scanner.hasNextInt()) { //prima di leggere, controlla se quello che andrà a leggere e un intero
                return new IntList(scanner.nextInt(), readFrom(scanner));
            } else {
                return null;
            }

        } catch (NoSuchElementException e) {    //se l’elemento letto non è un intero ...
            throw new IOException(e);   //... lancia un’eccezione (di tipo IOException(e))
        }

        //new IntList(1, new IntList(2, new IntList(3, null)));
    }
}
