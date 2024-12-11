package it.univr.cards;

import java.util.HashSet;
import java.util.TreeSet;

public class MainCards {
    public static void main(String[] args) {
        HashSet<Card> hashSet = new HashSet<>();    //1733942564908 ms
                                                    //con hashCode costante: 1733942828775 ms
        TreeSet<Card> treeSet = new TreeSet<>();    //1733942481488 ms
                                                    //con hashCode costante: 1733942739247 ms

        int counterHashSet = mainHashSet(hashSet);
        int counterTreeSet = mainTreeSet(treeSet);

        System.out.println("dimensione hashSet : " + counterHashSet);
        System.out.println("dimensione treeSet : " + counterTreeSet);
        if (hashSet.equals(treeSet))
            System.out.println("i due insiemi sono uguali (equals())");
        else
            System.out.println("i due insiemi sono diversi");
        System.out.println("tempo richiesto : " + System.currentTimeMillis() + " ms");
    }

    public static int mainHashSet(HashSet hashSet) {
        boolean aggiunto;
        int counterHashSet = 0;

        for (int counterCards = 0; counterCards < 100000000; counterCards++) {
            aggiunto = hashSet.add(new Card());
            if (aggiunto)
                counterHashSet++;
        }
        System.out.println("hashSet: " + hashSet);

        return counterHashSet;
    }

    public static int mainTreeSet(TreeSet treeSet) {
        boolean aggiunto;
        int counterTreeSet = 0;

        for (int counterCards = 0; counterCards < 100000000; counterCards++) {
            aggiunto = treeSet.add(new Card());
            if (aggiunto)
                counterTreeSet++;
        }
        System.out.println("treeSet: " + treeSet);

        return counterTreeSet;
    }
}
