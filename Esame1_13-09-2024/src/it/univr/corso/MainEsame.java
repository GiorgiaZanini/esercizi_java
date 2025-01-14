package it.univr.corso;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MainEsame {

	public static void main(String[] args) throws StudenteIllegaleException {
		Corso informatica = new Corso("Informatica", 3);
		Esame esame = new Esame("Programmazione Quantistica", informatica);

		// iscrive cinque studenti all'esame
		esame.iscrivi(new Studente("Giulio", "Rossi", 111564, 2021));
		esame.iscrivi(new Studente("Alessandra", "Allegri", 178066, 2024));
		esame.iscrivi(new StudenteLavoratore("Giordano", "Bruni", 98034, 2018));
		esame.iscrivi(new StudenteLavoratore("Giulio", "Andreotti", 34555, 2017));
		esame.iscrivi(new Studente("Antonietta", "Reale", 151535, 2020));

		// crea uno scanner connesso alla tastiera, legge uno studente da tale scanner
		// e lo iscrive all'esame; se si verifica una StudenteIllegaleException, allora ripete
		// la lettura dello studente e il tentativo di iscrizione, ad oltranza;
		// notate che per leggere uno studente da uno scanner esiste un metodo già fatto in Studente
		try (Scanner keyboard = new Scanner(System.in)) {
			while (true) {
				try {
					esame.iscrivi(Studente.leggiDaTastiera(keyboard));
					break;
				} catch (StudenteIllegaleException e) {
					System.out.println("Studente illegale, riprova");
				} catch (InputMismatchException e) {
					System.out.println("Studente illegale, riprova");
				}
			}
		}

		// stampa l'esame con tutti gli studenti iscritti
		System.out.println("\n" + esame);

		System.out.println("\nMatricole degli studenti fuori corso:");
		// chiamate perOgniIscritto per stampare le matricole degli studenti fuori corso iscritti all'esame

		Predicate<Studente> p = new Predicate<Studente>() {
			@Override
			public boolean test(Studente studente) {
				return studente.fuoriCorso(informatica);
			}
		};

		Consumer<Studente> c = new Consumer<Studente>() {
			@Override
			public void accept(Studente studente) {
				System.out.println(studente.getMatricola());
			}
		};

		esame.perOgniIscritto(p,c);

		System.out.println("\nStudenti lavoratori:");
		// chiamate perOgniIscritto per stampare gli studenti lavoratori iscritti all'esame

		p = new Predicate<Studente>() {
			@Override
			public boolean test(Studente studente) {
				return studente instanceof StudenteLavoratore;
			}
		};

		c = new Consumer<Studente>() {
			@Override
			public void accept(Studente studente) {
				System.out.println(studente.getMatricola());
			}
		};

		esame.perOgniIscritto(p,c);
	}
}
