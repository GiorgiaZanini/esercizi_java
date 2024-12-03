package it.univr.lists;

import java.io.IOException;
import java.io.PrintWriter;

public class List<T> {
    private final T head;
    private final List<T> tail;

    // crea una lista con la testa e la coda indicate
    public List(T head, List<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    // crea una lista contenente la testa indicata, seguita dagli elementi indicati
    public List(T head, T... elements) {
        this.head = head;

        /*
        T[] elementi = new T[elements.length];
        for (int i = 0; i < elements.length-1; i++) {
            elementi[i] = elements[i+1];
        }
        this.tail = new List<T>(elements[0], elementi);
        */

        List<T> list = null;

        for (int i = (elements.length - 1); i >= 0 ; i--) {
            list = new List<T>(elements[i], list);
        }

        this.tail = list;
    }

    // restituisce una descrizione di questa lista, fatta dai toString()
    // dei suoi elementi separati da virgole
    public String toString() {
        String string = head.toString();

        if (tail == null)
            return string;

        List<T> tempTail = tail;
        while (tempTail != null) {
            string = string + ", " + tempTail.head;
            tempTail = tempTail.tail;
        }

        return string;
    }

    // restituisce il numero di elementi di questa lista
    public int length() {
        int counterNodes = 1;
        if (tail == null)
            return counterNodes;

        List<T> tempTail = tail;
        while (tempTail != null) {
            counterNodes++;
            tempTail = tempTail.tail;
        }

        return counterNodes;
    }

    // scrive gli elementi di questa lista (cioè il loro toString())
    // dentro il file testuale col nome indicato (un PrintWriter vi aiuterà)
    public void dump(String fileName) throws IOException{
        PrintWriter printWriter = new PrintWriter(fileName);

        printWriter.print(this.head + " ");
        List<T> tempTail = tail;
        while (tempTail != null) {
            printWriter.print(tempTail.head + " ");
            tempTail = tempTail.tail;
        }

        printWriter.close();
    }
}
