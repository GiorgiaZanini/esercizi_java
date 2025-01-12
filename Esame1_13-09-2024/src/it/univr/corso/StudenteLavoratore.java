package it.univr.corso;

import java.time.Year;
import java.util.Calendar;

/**
 * Uno studente lavoratore è identico a uno studente ma finisce fuori corso
 * nel doppio di anni rispetto a uno studente non lavoratore.
 */
public class StudenteLavoratore extends Studente {
	// aggiungete campi se servissero

	public StudenteLavoratore(String nome, String cognome, int matricola, int annoDiImmatricolazione) throws StudenteIllegaleException {
		super(nome, cognome, matricola, annoDiImmatricolazione);
	}

	@Override
	public boolean fuoriCorso(Corso corso) {
		Calendar calendar = Calendar.getInstance();
		return (calendar.get(Calendar.YEAR) - getAnnoDiImmatricolazione()) > (corso.getDurata() * 2);
	}
}
