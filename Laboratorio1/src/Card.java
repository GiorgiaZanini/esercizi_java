import java.util.Random;

public class Card {
    /**
     * Il valore della carta.
     */
    private final int value;

    /**
     * Il seme della carta.
     */
    private final int suit;

    /**
     * Genera una carta a caso con un valore da min (incluso) in su.
     *
     * @param min il valore minimo (0-12) della carta che può essere generata
     */
    public Card(int min) {
        Random random = new Random();
        int valore;
        do {
            valore = random.nextInt(13);    //genera un numero random tra 0 e bound escluso
        } while (valore < min);

        value = valore;

        // value = random.nextInt(13 - min) + min;

        suit = random.nextInt(4);
    }

    /**
     * Genera una carta a caso con un valore da 0 (incluso) in su.
     */
    public Card() {
        // this(0);

        Random random = new Random();
        value = random.nextInt(13);

        suit = random.nextInt(4);
    }

    public int getValue() {
        return value;
    }

    public int getSuit() {
        return suit;
    }

    /**
     * Ritorna una descrizione della carta sotto forma di stringa, del tipo 10♠ oppure J♥.
     */
    public String toString() {
        String[] valori = {"2","3","4","5","6","7","8","9","10","J","Q","K","1"};
        String[] semi = {"♠","♣","♦","♥"};

        //return valori[value] + semi[suit];
        return valori[value] + semi[suit];
    }

    /**
     * Determina se questa carta è uguale ad other.
     *
     * @param other l'altra carta con cui confrontarsi
     * @return true se e solo se le due carte sono uguali
     */
    public boolean equals(Card other) {
        return value == other.value && this.suit == other.suit;
    }

    /**
     * Ordina le carte,
     * prima in base al valore, poi in base al seme.
     * @param other l'altra carta con cui confrontarsi
     *
     * @return
     * -1 se la carta è più piccola della carta other,
     * 0 se sono uguali.
     * 1 se la carta è più grande della carta other.
     */
    public int compareTo(Card other) {
        if (this.value != other.value) {
            if (this.value > other.value) {
                return 1;
            } else {
                return -1;
            }
        } else {
            if (this.suit != other.suit) {
                if (this.suit > other.suit) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return 0;
            }
        }
    }

}
