package it.univr.corso;

import java.util.SortedSet;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Un esame di un corso di laurea, con il nome dell'esame e il corso
 * di laurea a cui appartiene.
 */
public class Esame {
	// aggiungete campi se servissero
	private final String nome_esame;
	private final Corso corso;
	private SortedSet<Studente> iscritti;

	/**
	 * Crea un esame con il nome indicato, per il corso indicato, inizialmente senza iscritti.
	 */
	public Esame(String nome, Corso corso) {
		nome_esame = nome;
		this.corso = corso;
	}

	/**
	 * Iscrive lo studente indicato a questo esame.
	 * 
	 * @throws StudenteIllegaleException se ci fosse già uno studente
	 *                                   iscritto a questo esame con la stessa matricola
	 */
	public void iscrivi(Studente studente) throws StudenteIllegaleException {
		for (Studente s : iscritti) {
			if (s.getMatricola() == studente.getMatricola())
				throw new StudenteIllegaleException("numero matricola già registrata");
		}

		iscritti.add(studente);
	}

	// restituisce la stringa ottenuta concatenando tutti gli iscritti all'esame
	// in ordine crescente per matricola; all'inizio riporta nome dell'esame e corso;
	// si veda l'esempio nel testo del compito
	/*
	ESEMPIO DI ESECUZIONE

    Nome: Alessandro
    Cognome: Manzoni
    Matricola: 123456
    Anno di immatricolazione: 2025
    Studente illegale, riprova
    Nome: Alessandro
    Cognome: Manzoni
    Matricola: 123456
    Anno di immatricolazione: 2024
    Esame di Programmazione Quantistica del corso di Informatica:
    34555 Giulio Andreotti immatricolato nel 2017
    98034 Giordano Bruni immatricolato nel 2018
    111564 Giulio Rossi immatricolato nel 2021
    123456 Alessandro Manzoni immatricolato nel 2024
    151535 Antonietta Reale immatricolato nel 2020
    178066 Alessandra Allegri immatricolato nel 2024
    Matricole degli studenti fuori corso:
    34555
    151535
    Studenti lavoratori:
    34555 Giulio Andreotti immatricolato nel 2017
    98034 Giordano Bruni immatricolato nel 2018
	 */
	@Override
	public String toString() {
		String allStudents = "Esame di " + nome_esame + " del corso di " + corso.getNome() + ":\n";
		String fuoriCorso = "Matricole degli studenti fuori corso:\n";
		String lavoratori = "Studenti lavoratori:\n";

		for (Studente s : iscritti) {
			allStudents += s.toString() + "\n";

			if (s instanceof StudenteLavoratore) {
				lavoratori += s.toString() + "\n";
				if (((StudenteLavoratore) s).fuoriCorso(corso))
					fuoriCorso += s.getMatricola() + "\n";
			} else {
				if (s.fuoriCorso(corso))
					fuoriCorso += s.getMatricola() + "\n";
			}
		}

		if (allStudents.equals("Esame di " + nome_esame + " del corso di " + corso.getNome() + ":\n")) {
			allStudents += "-\n";
			fuoriCorso += "-\n";
			lavoratori += "-";
			return allStudents + fuoriCorso + lavoratori;
		} else {
			if (fuoriCorso.equals("Matricole degli studenti fuori corso:\n")) {
				fuoriCorso += "-\n";
			}
			if (lavoratori.equals("Studenti lavoratori:\n")) {
				lavoratori += "-\n";
			}
		}

		return (allStudents + fuoriCorso + lavoratori).trim();
	}

	/**
	 * Esegue l'azione indicata per ogni studente iscritto che soddisfa
	 * la condizione indicata.
	 */
	public void perOgniIscritto(Predicate<Studente> condizione, Consumer<Studente> azione) {
		for (Studente s : iscritti) {
			if (condizione.test(s))
				azione.accept(s);
		}
	}
}
