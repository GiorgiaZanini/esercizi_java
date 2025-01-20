package it.univr.quindici;

// Una tessera contiene un valore di tipo T. Si richiede che gli oggetti di tipo T
// siano comparabili fra di loro, in modo da sapere se una tessera viene prima di un'altra
public final class Tessera<T extends Comparable<T>> implements Comparable<Tessera<T>> {

	// il valore contenuto dentro la tessera
	private final T s;

	// crea una tessera che contiene il valore indicato
	Tessera(T s) {
		this.s = s;
	}

	public boolean equals(Object other) {
		// due tessere sono uguali se contengono valori uguali
		return other instanceof Tessera && ((Tessera<?>) other).s.equals(s);
	}

	public int hashCode() {	// modificate: non deve essere banale
		System.out.println(((Integer) s).toString());	// test per vedere hashCode se è fattibile
		return (Integer) s;
	}

	public String toString() {	// modificate (la stampa di una tessera deve essere la stampa del suo valore)
		return s.toString();	// intanto -> vedere se modificare
	}

	// mettiamo le tessere in ordine rispetto al valore che contengono;
	// lo possiamo fare perche' abbiamo richiesto i T comparabili fra di loro
	public int compareTo(Tessera<T> other) {	// modificate
		return this.s.compareTo(other.s);
	}
}