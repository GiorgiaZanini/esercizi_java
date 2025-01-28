package it.univr.dadi;

import java.util.Arrays;

/**
 * Una classe che rappresenta l'esecuzione di piu' lanci con dei dadi.
 * Permette di vedere i risultati ottenuti e la frequenza dei numeri ottenuti.
 */
public class Lanci {

	private final Dado[] dadi;
	private final int[] risultati;
	private int[] frequenza;

	/**
	 * Costruisce un'esecuzione di quanti lanci con i dadi indicati.
	 * Questo costruttore eseguire i lanci richiesti con i dadi forniti
	 * e si salvera' le informazioni necessarie a implementare i metodi
	 * della classe.
	 *
	 *
	 * @param quanti il numero di lanci da eseguire
	 * @param dadi i dadi da lanciare. Per ogni lancio, il risultato e'
	 *             la somma dei risultati di ciascun dado
	 * @throws IllegalArgumentException se quanti non e' positivo oppure
	 *         se non vengono forniti dadi da lanciare
	 */
	public Lanci(int quanti, Dado... dadi) {
		// completare

		// numero numero dadi da lanciare
		if (dadi.length == 0)
			throw new IllegalArgumentException("non sono stati forniti dadi da lanciare");
		this.dadi = dadi;

		// dadi da lanciare
		if (quanti < 0)	// numro di vote in cui lanciare i dadi
			throw new IllegalArgumentException("il numero di lanci non può essere negativo");
		risultati = new int[quanti];


		// lancio dadi
		int risultato;
		for (int i = 0; i < risultati.length; i++) {
			risultato = 0;
			for (int j = 0; j < dadi.length; j++) {
				risultato += dadi[j].lancio();
			}
			risultati[i] = risultato;
		}
	}

	/**
	 * Restituisce la sequenza dei risultati ottenuti dal costruttore lanciando i dadi.
	 * Sara' una stringa fatta da una sequenza, fra parentesi quadre, di numeri separati da virgola.
	 */
	@Override
	public final String toString() {
		return Arrays.toString(risultati);
	}

	/**
	 * Restituisce una rappresentazione a istogramma delle frequenze dei
	 * numeri ottenuti dal costruttore lanciando i dadi. Per ogni numero
	 * ottenuto, questi istogramma rappresentano quante volte quel numero e' stato
	 * ottenuto. Gli istogrammi sono fatti da una sequenza di asterischi lunga
	 * in modo proporzionale alla frequenza, seguita dalla frequenza tra parentesi
	 * tonde. Si vedano gli esempi nel testo del compito.
	 */
	public final String frequenze() {
		// completare

		// inizializzazione array della frequenza dei risultati
		int risultatoMax = 0;
		for (Dado dado : dadi)
			risultatoMax += dado.facce;

		frequenza = new int[risultatoMax];	// per default i valori sono 0

		// frequenze risultati
		for (int i = 0; i < risultati.length; i++) {
			frequenza[risultati[i]-1] += 1;
		}

		// toString
		String string = "";
		float percentuale;
		for (int i = dadi.length-1; i < risultatoMax; i++) {
			percentuale = (100 * (float) occorrenze(i+1) / risultati.length);
			//System.out.println(String.format("%f = (100 * %d / %d)", percentuale, occorrenze(i+1), risultati.length));
			string += String.format("%3s: ", i+1) + barra(i, percentuale) + String.format(" (%.1f%%)\n", percentuale);
		}
		return string;
    }

	/**
	 * Restituisce una barra di linghezza proporzianale
	 * alla frequenza indicata con cui si e' ottenuto il risultato "i" lanciando i dadi.
	 * Si trattera' di una sequenza di asterischi. Per esempio, se il numero 4
	 * fosse uscito nel 15.3% dei casi, allora questo metodo verra' chiamato con i = 4
	 * e frequenza = 15.3 e dovra' ritornare 15 asterischi.
	 */
	protected String barra(int i, double frequenza) {
		// completare
		return "*".repeat((int) frequenza);
	}

	private int occorrenze(int risultato) {
		int counter = 0;
		for (int i = 0; i < risultati.length; i++) {
			if (risultati[i] == risultato)
				counter++;
		}
		return counter;
	}
}
