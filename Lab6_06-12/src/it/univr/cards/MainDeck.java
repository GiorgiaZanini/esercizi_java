package it.univr.cards;

public class MainDeck {
    public static void main(String[] args) {
        Deck deck1 = new Deck(5,Value.SETTE);
        System.out.println(deck1);
        System.out.println("best of deck1: " + deck1.best());
        System.out.print("deck1 without " + deck1.best() + ": ");
        deck1.removeBest();
        System.out.println(deck1);

        System.out.println();

        Deck deck2 = new Deck(5,Value.CINQUE);
        System.out.println(deck2);
        System.out.println("best of deck2: " + deck2.best());

        System.out.println();

        Deck deck3 = new Deck(52,Value.DUE);    // 52 -> dimensione di un deck completo
        System.out.println(deck3);
        System.out.println("best of deck3: " + deck3.best());
    }
}
