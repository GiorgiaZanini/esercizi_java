package it.univr.letters;

import java.util.Random;
import java.util.function.Consumer;

/**
 * Una sequenza di caratteri "minuscola", cioe' fatta da
 * lettere minuscole dell'alfabeto inglese.
 * Sono ammesse lettere ripetute.
 */
public class LowerCase implements Letters {
	protected final static Random random = new Random();
	// AGGIUNGERE QUI CAMPI PRIVATI SE SERVISSERO
	private String sequenza = "";
	private final static String lettereLower = "abcdefghijklmnopqrstuvwxyz";	//26

	/**
	 * Crea una sequenza minuscola casuale.
	 * 
	 * @param length la lunghezza della sequenza da creare
	 * @throws IllegalArgumentException se length e' negativo
	 */
	public LowerCase(int length) {
		// COMPLETARE
		if (length < 0)
			throw new IllegalArgumentException("length non può assere negativo, lenght passato: " + length);

		//sequenza = "";
		for (int i = 0; i < length; i++) {
			sequenza += lettereLower.charAt(random.nextInt(26));
		}
	}

	/**
	 * Crea una sequenza minuscola fatta dai caratteri di s, identici,
	 * nello stesso ordine.
	 * 
	 * @param s la stringa che contiene i caratteri da inserire nella sequenza
	 * @throws IllegalArgumentException se i caratteri di s non sono una sequenza minuscola
	 */
	public LowerCase(String s) {
		// COMPLETARE
		char[] seq = s.toCharArray();
		for (Character character : seq)
			if (!(lettereLower.contains(character.toString())))
				throw new IllegalArgumentException("la sequenza contiene caratteri non compatibili con una sequenza randomica di caratteri minuscoli");
		sequenza = s;
	}

	@Override
	public final int length() {	// MODIFICARE E COMPLETARE
		return sequenza.length();
	}

	@Override
	public final String toString() {	// MODIFICARE E COMPLETARE
		return sequenza;
	}

	@Override
	public final void forEach(Consumer<Character> what) {
		// COMPLETARE
		char[] seqChar = sequenza.toCharArray();
		sequenza = "";
		for (Character character : seqChar) {
			what.accept(character);
			sequenza += character;	// mette nella stinga il character modificato
		}
	}
}