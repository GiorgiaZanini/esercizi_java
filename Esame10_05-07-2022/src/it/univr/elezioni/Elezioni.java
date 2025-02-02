package it.univr.elezioni;

import java.util.*;

/**
 * Un oggetto di questa classe permette di registrare voti per dei partiti.
 * Iterando su questo oggetto, si ottengono delle coppie partito/voti ottenuti,
 * messe in ordine crescente per partito.
 */
public class Elezioni implements Iterable<VotiPerPartito> {

	//private SortedSet<Partito> partiti = new TreeSet<>();
	private Map<Partito, Integer> elezioni = new TreeMap<>();

	// registra un voto per il partito indicato
	public final void vota(Partito partito) {
		// completare
		if (elezioni.get(partito) == null)
			elezioni.put(partito, 1);
		else
			elezioni.put(partito, elezioni.get(partito) + 1);
		// elezioni.merge(partito, 1, Integer::sum);
	}

	/**
	 * Ritorna una stringa che descrive l'elezione, del tipo:

1        Bassotti:  4467 voti (28.11%)
2         Caotico:  4679 voti (29.45%)
3          Felice:  1591 voti (10.01%)
4        Floreale:  3950 voti (24.86%)
5      Pensionati:  1202 voti (7.56%)

	   I partiti sono riportati in ordine crescente, con a sinistra un indice
	   crescente del partito (da 1 in su). Dopo il nome del partito viene riportato
	   il numero dei voti ottenuti e la percentuale ottenuta fra tutti i voti espressi.
	 */
	@Override
	public String toString() {	// modificare
		float votiTot = 0;
		for (Partito partito : elezioni.keySet()) {
			votiTot += elezioni.get(partito);
		}

		String string = "";

		int i = 1;
		for (Partito partito : elezioni.keySet()) {
			string += String.format("%d %15s: %5d voti (%.2f%%)\n", i, partito, elezioni.get(partito), ((100 * elezioni.get(partito)/votiTot)));	//%s -> stringa
			i++;
		}

		return string;
	}

    /**
     * Iterando su questo oggetto, si ottengono delle coppie partito/voti ottenuti,
     * messe in ordine crescente per partito.
     */
	@Override
	public final Iterator<VotiPerPartito> iterator() {	// modificare
		SortedSet<VotiPerPartito> set = new TreeSet<VotiPerPartito>(new Comparator<VotiPerPartito>() {
			@Override
			public int compare(VotiPerPartito thisVoti, VotiPerPartito otherVoti) {
				return thisVoti.partito.compareTo(otherVoti.partito);
			}
		});

		for (Partito partito : elezioni.keySet()) {
			set.add(new VotiPerPartito(partito, elezioni.get(partito)));
		}

		return set.iterator();
	}
}
