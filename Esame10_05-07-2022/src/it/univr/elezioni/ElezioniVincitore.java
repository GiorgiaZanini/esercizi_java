package it.univr.elezioni;

import java.util.Iterator;

/**
 * Un tipo di elezione la cui stampa aggiunge l'indicazione
 * di quale partito ha vinto le elezioni.
 */
public class ElezioniVincitore extends Elezioni {

	/**
	 * Si comporta come il toString() della superclasse, ma in piu'
	 * aggiunge in fondo l'indicazione del partito che ha vinto le elezioni,
	 * del tipo "Vince X".
	 * In particolare, vince l'elezione il partito che ha ottenuto piu' voti.
	 * A parita' di voti, vince il partito che viene prima in ordine alfabetico.
	 * Se non ci fossero partiti (elezione vuota), aggiunge l'indicazione
	 * "Non ci sono vincitori".
	 */
	@Override
	public String toString() {	// modificare
		String vincitore = "";
		int max = 0;

		Iterator<VotiPerPartito> iterator = iterator();
		if (iterator.hasNext()) {
			if (iterator.next().voti > max) {
				vincitore = iterator.next().partito.toString();
				max = iterator.next().voti;
			}
			else if (iterator.next().voti == max)
				vincitore += " e " + iterator.next().partito;
		}

		return super.toString() + "\nVince " + vincitore;
	}
}