package it.univr.lists;

import java.io.IOException;
import java.io.PrintWriter;

public class List<T> {
    private final T head;
    private final List<T> tail;

    // crea una lista con la testa e la coda indicate
    public List(T head, List<T> tail) {
        this.head = head;   //testa
        this.tail = tail;   //elemento successivo (next)
    }

    // crea una lista contenente la testa indicata, seguita dagli elementi indicati
    public List(T head, T... elements) {
        this.head = head;   //assegnata la testa (“value”)

        /*
        T[] elementi = new T[elements.length];          //non si può istanziare un array di tipo T
        for (int i = 0; i < elements.length-1; i++) {
            elementi[i] = elements[i+1];
        }
        this.tail = new List<T>(elements[0], elementi);
        */

        List<T> list = null;

        for (int i = (elements.length - 1); i >= 0 ; i--) {     //metodo ricorsivo -> parte dall’ultimo elemento della lista, costruendo ogni nodo tramite il primo costruttore, e salvata mano a mano in list
            list = new List<T>(elements[i], list);  //prende in input “testa” e “elemento successivo”
        }

        this.tail = list;   //alla fine “collega” la testa alla coda (la coda è l’elemento successivo (“next”))

    }

    // restituisce una descrizione di questa lista, fatta dai toString()
    // dei suoi elementi separati da virgole
    public String toString() {
        String string = head.toString();

        if (tail == null)
            return string;

        List<T> tempTail = tail;
        while (tempTail != null) {
            string = string + ", " + tempTail.head; //aggiunge il valore del nodo alla stringa
            tempTail = tempTail.tail;   //passa al nodo successivo
        }

        return string;
    }

    // restituisce il numero di elementi di questa lista
    public int length() {
        int counterNodes = 1;
        if (tail == null)
            return counterNodes;    //se c’è solo un nodo ritorna i counter dei nodi a 1

        List<T> tempTail = tail;
        while (tempTail != null) {
            counterNodes++;     //conta il nodo corrente
            tempTail = tempTail.tail;   //passa al nodo successivo
        }

        return counterNodes;
    }

    // scrive gli elementi di questa lista (cioè il loro toString())
    // dentro il file testuale col nome indicato (un PrintWriter vi aiuterà)
    public void dump(String fileName) throws IOException{   //dump = “buttare fuori” -> In questo caso scrivere su file (struttura dati salvata nella ram)
        PrintWriter printWriter = new PrintWriter(fileName);    //per sola scrittura su file

        printWriter.print(this.head + " ");
        List<T> tempTail = tail;
        while (tempTail != null) {  //come il toString, cicla sui nodi e li scrive mano mano
            printWriter.print(tempTail.head + " ");
            tempTail = tempTail.tail;
        }

        printWriter.close();    //chiude il file (in scrittura)
    }
}
