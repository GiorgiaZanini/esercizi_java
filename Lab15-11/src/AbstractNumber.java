public abstract class AbstractNumber implements Number {
    private final int value;

    // se value è negativo, esegue throw new IllegalArgumentException(); altrimenti inizializza il campo value
    protected AbstractNumber(int value) {
        if (value < 0) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    // restituisce il valore di questo numero
    public final int getValue() {
        return this.value;
    }

    // restituice la base di numerazione di questo numero
    protected abstract int getBase();

    // restituisce il carattere che rappresenta la cifra "digit" nella base di numerazione
    // di questo numero. Sarà sempre vero che 0 <= digit < getBase();
    // per esempio, in base sedici si avrà getCharForDigit(10) == 'A' e
    // in base otto si avrà getCharForDigit(7) == '7'
    protected abstract char getCharForDigit(int digit);

    // restituisce una stringa che rappresenta il numero nella sua base di numerazione
    @Override
    public String toString() {
        String string = "";

        int val = this.value;
        do {
            string = getCharForDigit(val % getBase()) + string;
            val = val/getBase();
        } while (val > 0);

        return string;
    }

    // due numeri sono uguali se e solo se hanno lo stesso valore
    @Override
    public final boolean equals(Object other) {
        if (!(other instanceof Number)) {
            return false;
        }

        //other = (Number) other;   NO -> ridondante perché other resta di tipo Object

        //((Number) other).getValue();  scrivere ogni volta il tipo da considerare

        Number otherNumb = (Number) other; //cast
        return this.value == otherNumb.getValue();
    }

    // l'ordinamento fra i Number è quello crescente per valore
    @Override
    public final int compareTo(Number other) {
        if (this.value < other.getValue()) {
            return -1;
        } else if (this.value == other.getValue()) {
            return 0;
        } else {
            return 1;
        }
    }
}
