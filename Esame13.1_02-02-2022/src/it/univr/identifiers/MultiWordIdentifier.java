package it.univr.identifiers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// un identificatore fatto da piu' parole in sequenza
public abstract class MultiWordIdentifier implements Identifier {

	// TODO
	private final ArrayList<String> words;
	private final static String lettere = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	// fallisce con una IllegalArgumentException se non c'e' nessuna parola
	// o se c'e' una parola null oppure vuota
	// o se una parola contiene un carattere non alfabetico
	protected MultiWordIdentifier(String... words) throws IllegalArgumentException {	// se non vengono psassati parametri va in errore da solo
		// TODO
		if (words.length == 0)
			throw new IllegalArgumentException();
        for (String word : words) {
            if (word == null || word.isEmpty())
                throw new IllegalArgumentException();
			for (int i = 0; i < word.length(); i++) {
				if (!(lettere.contains(((Character) word.charAt(i)).toString())))
					throw new IllegalArgumentException();
			}
        }
		this.words = new ArrayList<>(List.of(words));
	}

	// fallisce con un'eccezione nelle stesse condizioni viste sopra
	protected MultiWordIdentifier(Iterable<String> words) throws IllegalArgumentException {
		// TODO
		/*
		if (words == null || words.iterator().hasNext())
			throw new IllegalArgumentException();

		*/

		this.words = new ArrayList<>();
		Iterator<String> iterator = words.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			if (next == null || next.isEmpty())
				throw new IllegalArgumentException();
			this.words.add(next);
		}
		/*
		for (String next : words) {
            if (next == null || next.isEmpty())
                throw new IllegalArgumentException();
            this.words.add(next);
        }
		*/
	}

	@Override
	public final String toString() {
		// TODO: si richiami il metodo ausiliario toString(pos, word)
		// e si concateni il risultato in un'unica stringa
		String string = "";

		/*
		for (String word : words)
			string += toString(words.indexOf(word), word);
		 */
		for (int i = 0; i < words.size(); i++) {
			string += toString(i, words.get(i));
		}

		return string;
	}

	// restituisce la stringa con cui si stampa la componente pos-esima dell'identificatore
	protected abstract String toString(int pos, String word);

	// restituisce la concatenazione delle parole degli identificatori indicati
	protected static List<String> concat(MultiWordIdentifier... ids) {
		// TODO
		List<String> list = new ArrayList<>();
		for (MultiWordIdentifier identifier : ids) {
            list.addAll(identifier.words);
		}
		return list;
	}

	// POTETE AGGIUNGERE METODI PRIVATE
}
