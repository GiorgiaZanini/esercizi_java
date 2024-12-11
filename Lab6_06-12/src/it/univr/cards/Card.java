package it.univr.cards;

import java.util.Objects;
import java.util.Random;

public class Card {
    /**
     * Il valore della carta.
     */
    private final Value value;

    /**
     * Il seme della carta.
     */
    private final Suit suit;

    /**
     * Genera una carta a caso con un valore da min (incluso) in su.
     *
     * @param min il valore minimo (0-12) della carta che può essere generata
     */
    public Card(Value min) {
        Random random = new Random();
        value = Value.values()[random.nextInt(13 - min.ordinal()) + min.ordinal()];
        suit = Suit.values()[random.nextInt(4)];
    }

    /**
     * Genera una carta a caso con un valore da 0 (incluso) in su.
     */
    public Card() {
        this(Value.DUE);
    }

    public Value getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    /**
     * Ritorna una descrizione della carta sotto forma di stringa, del tipo 10♠ oppure J♥.
     */
    public String toString() {
        String[] valori = {"2","3","4","5","6","7","8","9","10","J","Q","K","1"};
        String[] semi = {"♠","♣","♦","♥"};

        return valori[value.ordinal()] + semi[suit.ordinal()];
    }

    /**
     * Determina se questa carta è uguale ad other.
     *
     * @param other l'altra carta con cui confrontarsi
     * @return true se e solo se le due carte sono uguali
     */
    public boolean equals(Object other) {
        if (!(other instanceof Card))
            return false;

        return value.equals(((Card) other).value) && suit.equals(((Card) other).suit);
    }

    @Override
    public int hashCode() {
        return (value.ordinal() * 10) + suit.ordinal();
    }
}
