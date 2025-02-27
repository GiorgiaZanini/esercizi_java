package it.univr.quindici;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// un gioco con tessere che contengono valori di tipo T
public class Gioco<T extends Comparable<T>> {
	private final int width, height;
	
	// le tessere del gioco: questa lista le contiene per righe
	// (la prima riga seguita dalla seconda riga seguita dalla terza riga ecc.);
	// questa lista contiene null nel punto vuoto del gioco
	private final List<Tessera<T>> tessere;

	public Gioco(FattoriaDiTessere<T> fattoria, int width, int height) {
		this.width = width;
		this.height = height;
		
		// costruite la lista "tessere": dovra' contenere
		// tessere casuali tutte diverse fra di loro
		// e un elemento casuale a null: in totale la lista "tessera"
		// dovra' avere quindi width * height elementi di cui uno solo a null

		// modificate

		Random random = new Random();
		int tesseraNull = random.nextInt(width * height);
		tessere = new ArrayList<>(width * height);
		for (int i = 0; i < width * height; i++) {
			if (i == tesseraNull)
				tessere.add(null);
				//tessere.set(i, null);
			else
				tessere.add(fattoria.get());
		}
	}

	// restituisce il gioco come una stringa: non modificate
	public String toString() {
		String result = "";

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++)
				if (tessere.get(x + y * width) != null)
					result += String.format("%5s ", tessere.get(x + y * width).toString());
				else
					result += "      ";

			result += "\n";
		}

		return result;
	}

	// determina se il gioco e' risolto:
	// 1) la posizione vuota deve essere in basso a destra, e
	// 2) le tessere devono essere in ordine crescente (per riga e colonna)
	public boolean risolto() {	// modificate
		if (tessere.get((width * height) - 1) != null)
			return false;

		for (int i = 0; i < (width * height) - 2; i++) {
			if (tessere.get(i).compareTo(tessere.get(i + 1)) >= 0)
				return false;
		}
		return true;
	}
}
