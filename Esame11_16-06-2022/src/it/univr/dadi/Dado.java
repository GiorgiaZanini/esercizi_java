package it.univr.dadi;

import java.util.Random;

/**
 * Un dado ha un numero prefissato di facce e può essere lanciato.
 */
public abstract class Dado {

	/**
	 * Il numero di facce del dado. Si noti che e' pubblico.
	 */
	public final int facce;
	private static final Random random = new Random();

	/**
	 * Costruisce un dado con un numero prefissato di facce.
	 * Lancia IllegalArgumentException il numero di facce non e' positivo.
	 */
	protected Dado(int facce) {
		// completare
		/*
		if (facce < 0)
			throw new IllegalArgumentException("il numero di facce di un dado non può essere negativo");
		*/

		if (facce < 1)
			throw new IllegalArgumentException("il numero di facce di un dado non può essere negativo");

		/*
		// ???
		if (facce < 2)	// in aggiunta, non può esistere un dado a 0 o 1 faccia
						// anche se esistesse, in lancio si parte da 1
			throw new IllegalArgumentException("non esiste un dado di " + facce + " facce");
		*/

		this.facce = facce;
	}

	/**
	 * Restituisce un numero casuale fra 1 (incluso) e il numero di facce del dado (incluso).
	 */
	public final int lancio() {
		// completare
		return random.nextInt(facce) + 1;
	}
}
