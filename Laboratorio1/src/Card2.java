import java.util.Random;

public class Card2 {
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
    public Card2(Value min) {
        Random random = new Random();
        int valore;
        do {
            valore = random.nextInt(13);
        } while (valore < min.ordinal());   //ordinal() ritorna l’indice della posizione del “segnaposto” all’interno dell’enumerazione


                value = (Value.values())[valore];   // values() ritorna a modi array i valori dentro Enum

        /*
        switch (valore) {
            case 0:
                value = Value.DUE;
                break;
            case 1:
                value = Value.TRE;
                break;
                // .....
         }
         */

        // value = random.nextInt(13 - min) + min;

        suit = Suit.values()[random.nextInt(4)];
    }

    /**
     * Genera una carta a caso con un valore da 0 (incluso) in su.
     */
    public Card2() {
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
    public boolean equals(Card2 other) {
        return value.equals(other.value) && suit.equals(other.suit);
    }
}
