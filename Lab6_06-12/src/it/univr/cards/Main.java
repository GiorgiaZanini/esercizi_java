package it.univr.cards;

public class Main {
    public static void main(String[] args) {
        Card card1 = new Card(Value.DUE);
        System.out.println(card1);
        
        Card card;
        do {
            card = new Card(Value.DUE);
            System.out.println(card);
        } while (!card1.equals(card));
    }
}