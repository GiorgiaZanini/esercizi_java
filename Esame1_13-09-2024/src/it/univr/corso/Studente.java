package it.univr.corso;

import java.util.Date;	// rappresentare una data e un’ora (da Java 8)
import java.util.Calendar;	// ottenere la data e l’ora attuali (da Java 8)
import java.time.LocalDateTime;	// ottenere la data e l’ora attuali (da Java 8)
import java.util.Scanner;

/**
 * Uno studente, che si puo' iscrivere agli esami di un corso di laurea.
 */
public class Studente implements Comparable<Studente> {
	private final String nome;
	private final String cognome;
	private final int matricola;
	private final int annoDiImmatricolazione;

	/**
	 * Crea uno studente con il nome, cognome, matricola e anno di immatricolazione indicati.
	 * 
	 * @throws StudenteIllegaleException se l'anno di immatricolazione è nel futuro
	 *                                   o se la matricola è negativa
	 */
	public Studente(String nome, String cognome, int matricola, int annoDiImmatricolazione) throws StudenteIllegaleException {
		this.nome = nome;
		this.cognome = cognome;

		if (matricola < 0)
			throw new StudenteIllegaleException("numero di matricola negativo");
		this.matricola = matricola;

		Calendar calendar = Calendar.getInstance();
		if (annoDiImmatricolazione > calendar.get(Calendar.YEAR))	// calendar.get(Calendar.YEAR) -> ritorna anno corrente
																	// Calendar.YEAR è un intero che serve per riferirsi al campo dell'anno in un oggetto Calendar
			throw new StudenteIllegaleException("anno futuro rispetto a quello corrente");
		this.annoDiImmatricolazione = annoDiImmatricolazione;
	}

	/**
	 * Legge da tastiera i dati di uno studente, lo crea e lo restituisce.
	 * Già fatto, non modificate.
	 * 
	 * @throws StudenteIllegaleException se i dati letti sono illegali
	 */
	public static Studente leggiDaTastiera(Scanner keyboard) throws StudenteIllegaleException {
		System.out.print("Nome: ");
		String nome = keyboard.nextLine();
		System.out.print("Cognome: ");
		String cognome = keyboard.nextLine();
		System.out.print("Matricola: ");
		int matricola = keyboard.nextInt(); keyboard.nextLine();
		System.out.print("Anno di immatricolazione: ");
		int annoDiImmatricolazione = keyboard.nextInt(); keyboard.nextLine();

		return new Studente(nome, cognome, matricola, annoDiImmatricolazione);
	}

	/**
	 * Due studenti sono uguali se e solo se hanno la stessa matricola.
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Studente))
			return false;

        return this.matricola == ((Studente) other).matricola;
    }

	/**
	 * Deve essere non banale e compatibile con equals.
	 */
	@Override
	public int hashCode() {
		return matricola;
	}

	/**
	 * Determina chi viene prima (per matricola) tra this e other.
	 */
	@Override
	public int compareTo(Studente other) {
		/*
		if (this.matricola > other.matricola)
			return 1;
		if (this.matricola < other.matricola)
			return -1;
		return 0;
		 */
		return Integer.compare(this.matricola, other.matricola);
	}

	// restituisce una stringa del tipo "34555 Giulio Andreotti immatricolato nel 2017"
	@Override
	public String toString() {
		return matricola + " " + nome + " " + cognome + " immatricolato nel " + annoDiImmatricolazione;
	}

	/**
	 * Determina se questo studente e' fuori corso rispetto al corso di laurea indicato:
	 * ovvero se si e' immatricolato prima della durata del corso di laurea.
	 */
	//return true -> fuori corso
	public boolean fuoriCorso(Corso corso) {
		return annoDiImmatricolazione > (annoDiImmatricolazione + corso.getDurata());
	}

	// aggiungete i metodi accessori pubblici getAnnoDiImmatricolazione() e getMatricola()

	public int getAnnoDiImmatricolazione() {
		return annoDiImmatricolazione;
	}

	public int getMatricola() {
		return matricola;
	}
}
