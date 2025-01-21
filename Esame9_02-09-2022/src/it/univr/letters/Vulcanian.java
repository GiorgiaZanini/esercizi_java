package it.univr.letters;

import java.util.Arrays;

/**
 * Una sequenza vulcaniana di lettere, cioe'
 * un caso particolare di sequenza LowerCase che e' fatta da due parti:
 * la prima parte contiene vocali in ordine alfabetico;
 * la seconda parte contiene consonanti in ordine alfabetico.
 */
public class Vulcanian extends LowerCase {

	// AGGIUNGERE QUI CAMPI PRIVATI SE SERVISSERO
	private final static String lettereLower = "abcdefghijklmnopqrstuvwxyz";	//26

	/**
	 * Crea una sequenza vulcaniana di length lettere.
	 * 
	 * @param length la lunghezza della sequenza da creare
	 * @throws IllegalArgumentException se length e' negativo
	 */	
	public Vulcanian(int length) {
		super(randomVulcanian(length));
	}

	/**
	 * Genera una stringa vulcaniana casuale lunga length.
	 */
	private static String randomVulcanian(int length) {	// MODIFICARE E COMPLETARE
		String sequenza = "";

		for (int i = 0; i < length; i++) {
			sequenza += lettereLower.charAt(random.nextInt(26));
		}

		return ordinamentoVulcaniano(sequenza);
	}
	/*
	private static String randomVulcanian(int length) {	// MODIFICARE E COMPLETARE
		String sequenzaVulcaniana = "";
		String sequenzaTmp = "";

		for (int i = 0; i < length; i++) {
			sequenzaTmp += lettereLower.charAt(random.nextInt(26));
		}

		char seqTmp[] = sequenzaTmp.toCharArray();	// creo un array da tmp (random)
		sequenzaTmp = "";	// azzero tmp per riciclarla
		Arrays.sort(seqTmp);	// ordino i char, così sono già in ordine per poi separarli
		for (Character character : seqTmp) {
			if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u')
				sequenzaVulcaniana += character;	// la prima parte di una sequenza vulcaniana sono le vocali
			else
				sequenzaTmp += character;	// uso tmp per le vocali
		}

		sequenzaVulcaniana += sequenzaTmp;
		return sequenzaVulcaniana;
	}
	 */

	/**
	 * Crea una sequenza vulcaniana fatta dai caratteri di s,
	 * identici, nello stesso ordine.
	 * 
	 * @param s la stringa che contiene i caratteri da inserire nella sequenza
	 * @throws IllegalArgumentException se i caratteri di s non formano
	 *                                  una sequenza vulcaniana
	 */
	public Vulcanian(String s) {	// MODIFICARE E COMPLETARE
		super(s);
		if (!(s.equals(ordinamentoVulcaniano(s))))
			throw new IllegalArgumentException("la sequenza non è in ordine vulcaniano");
	}

	private static String ordinamentoVulcaniano(String sequenza) {
		char seq[] = sequenza.toCharArray();	// creo un array dalla sequenza passata
		String vocali = "";
		String consonanti = "";

		Arrays.sort(seq);	// ordino i char, così sono già in ordine per poi separarli

		for (Character character : seq) {
			if (!(lettereLower.contains(character.toString())))
				throw new IllegalArgumentException("sequenza non convertibile a sequenza vulcaniana");

			if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u')
				vocali += character;	// la prima parte di una sequenza vulcaniana sono le vocali
			else
				consonanti += character;	// uso tmp per le vocali
		}

		return vocali + consonanti;
	}
}