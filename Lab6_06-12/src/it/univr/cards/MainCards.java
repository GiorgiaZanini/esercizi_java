package it.univr.cards;

import java.util.HashSet;
import java.util.TreeSet;

public class MainCards {
    public static void main(String[] args) {
        HashSet<Card> hashSet = new HashSet<>();
        TreeSet<Card> treeSet = new TreeSet<>();

        boolean aggiunto;
        int counterHashSet = 0;
        int counterTreeSet = 0;

        for (int counterCards = 0; counterCards < 100000000; counterCards++) {
            aggiunto = hashSet.add(new Card());
            if (aggiunto)
                counterHashSet++;
        }
        System.out.println("hashSet: " + hashSet);

        for (int counterCards = 0; counterCards < 100000000; counterCards++) {
            aggiunto = treeSet.add(new Card());
            if (aggiunto)
                counterTreeSet++;
        }
        System.out.println("treeSet: " + treeSet);


        System.out.println("dimensione hashSet : " + counterHashSet + "\n" + "dimensione treeSet : " + counterTreeSet);
        if (hashSet.equals(treeSet))
            System.out.println("i due insiemi sono uguali (equals())");
        else
            System.out.println("i due insiemi sono diversi");
        System.out.println("tempo richiesto : " + System.currentTimeMillis() + " ms");
    }
}
